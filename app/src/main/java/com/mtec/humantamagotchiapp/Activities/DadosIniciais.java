package com.mtec.humantamagotchiapp.Activities;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.android.material.textfield.TextInputEditText;
import com.mtec.humantamagotchiapp.R;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class DadosIniciais extends AppCompatActivity {

    TextInputEditText nome;
    TextInputEditText peso;
    TextInputEditText altura;
    EditText dtNascimento;
    RadioGroup radioGroupSexo;
    Button bt_NextScreen;

//================================================================================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_iniciais);

         nome = findViewById(R.id.inputName);
         peso = findViewById(R.id.inputPeso);
         altura =  findViewById(R.id.inputAltura);
         dtNascimento = findViewById(R.id.inputData);
         radioGroupSexo = findViewById(R.id.radioGroupSexo);
         bt_NextScreen = findViewById(R.id.bt_EnviarDadosIniciais);
         mask();


         bt_NextScreen.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                  if(!valida(findViewById(R.id.parent))){
                      //chama próxima tela
                  } else{
                      //informa o usuário sobre os campos vazios
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
                if( text == null || text.equals("")){
                    isEmpty = true;
                    Log.w("TAG", "Algum campo de texto está vazio.");
                }
            }

            if(view instanceof RadioGroup){
                int checked = 0;
                checked = ((RadioGroup) view).getCheckedRadioButtonId();
                if(checked != 0){
                    isRadioButtonSelected = true;
                    Log.w("TAG", "Algum radioButton deve ser marcado");
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

}
