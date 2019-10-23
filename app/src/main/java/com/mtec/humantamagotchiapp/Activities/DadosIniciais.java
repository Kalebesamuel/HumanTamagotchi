package com.mtec.humantamagotchiapp.Activities;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.android.material.textfield.TextInputEditText;
import com.mtec.humantamagotchiapp.R;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Classes.DataBase;
import Classes.User;


public class DadosIniciais extends AppCompatActivity {

    TextInputEditText nome;
    TextInputEditText peso;
    TextInputEditText altura;
    EditText dtNascimento;
    RadioGroup radioGroupSexo;
    Button bt_NextScreen;
    Calendar calendar = Calendar.getInstance();
    Date date = null;
    DatePickerDialog datePickerDialog;
    DataBase db;
    //AlertDialog alert;

//================================================================================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_iniciais);

         nome = findViewById(R.id.inputName);
         peso = findViewById(R.id.inputPeso);
         altura
                 =  findViewById(R.id.inputAltura);
         dtNascimento = findViewById(R.id.inputData);
         radioGroupSexo = findViewById(R.id.radioGroupSexo);
         bt_NextScreen = findViewById(R.id.bt_EnviarDadosIniciais);
         mask();


         datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
             @Override
             public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                 Calendar selectDate = Calendar.getInstance();
                 selectDate.set(year, month, day);
                 date = selectDate.getTime();
                 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                 dtNascimento.setText(sdf.format(date));
             }
         }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

         dtNascimento.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 datePickerDialog.show();
             }
         });

         db = Room.databaseBuilder(this, DataBase.class, "dbHT").build();


         bt_NextScreen.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                  if(!valida(findViewById(R.id.parent))){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            User user = new User(0, nome.getText().toString(), date,
                                    Double.parseDouble(peso.getText().toString()),//erro no parseDouble
                                    Double.parseDouble(altura.getText().toString()));
                            db.userDao().insert(user);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(DadosIniciais.this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    });

                      callNextPage();
                  }
             }
         });
    }

//================================================================================================================================================

    public void mask(){

        SimpleMaskFormatter pesoMask = new SimpleMaskFormatter("NN,NN");//resolver questão do peso, caso o usuário tenha mais que 100Kg
        MaskTextWatcher maskPesoWatcher = new MaskTextWatcher(peso, pesoMask);
        peso.addTextChangedListener(maskPesoWatcher);
        SimpleMaskFormatter alturaMask = new SimpleMaskFormatter("N,NN");
        MaskTextWatcher maskAlturaWatcher = new MaskTextWatcher(altura, alturaMask);
        altura.addTextChangedListener(maskAlturaWatcher);
        SimpleMaskFormatter dataMask = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher maskDataWatcher = new MaskTextWatcher(dtNascimento, dataMask);
        dtNascimento.addTextChangedListener(maskDataWatcher);

    }


//================================================================================================================================================

    /**Recebe como parametro um pai e percorre todos os seus filhos, verificando se
     * estão vazios, ou não selecioandos, caso algum deles estejam retorna true;
     * @param parent
     * @return boolean
     */

    public boolean valida(ViewGroup parent){
        int count = parent.getChildCount();
        boolean isEmpty = false;
        boolean isRadioButtonSelected = false;

        for(int i = 0; i < count; i++){
            View view = parent.getChildAt(i);
            if(view instanceof EditText || view instanceof TextInputEditText){
                String text = ((EditText)view).getText().toString();
                if( text == null || text.isEmpty()){
                    isEmpty = true;
                    Log.w("TAG", "Algum campo de texto está vazio.");
                } else {
                    isEmpty = false;
                }
            }

            if(view instanceof RadioGroup){
                int checked = 0;
                checked = ((RadioGroup) view).getCheckedRadioButtonId();
                Log.w("TAG", "checked: " + checked);
                Log.w("TAG", "id: " + R.id.rB_M);

                if(checked == -1){// validar aquic
                    isRadioButtonSelected = true;
                    Log.w("TAG", "Algum radioButton deve ser marcado");
                } else {
                    isRadioButtonSelected = false;
                }
            }
        }

        if(isEmpty || isRadioButtonSelected){
            return true;
        }
        return false;
    }

//================================================================================================================================================

    /**Recebe como parametro um pai e percorre todos os seus filhos, caso sejam
     * inputs de textos, seta "" como valor.
     * @param parent
     */
    public void clearFields(ViewGroup parent){

        int count = parent.getChildCount();
        for(int i = 0; i < count; i++){
            View view = parent.getChildAt(i);
            if(view instanceof  EditText || view instanceof TextInputEditText){
                ((EditText)view).setText("");
            } ///limpar radioButtons ????
        }

    }

//================================================================================================================================================
public void callNextPage(){
        Intent intent = new Intent(this, Opcao.class);
        startActivity(intent);
    }

//================================================================================================================================================
}
