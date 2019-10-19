package com.mtec.humantamagotchiapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.mtec.humantamagotchiapp.R;
import android.os.Bundle;
import android.widget.RadioGroup;

import java.util.Date;

public class DadosIniciais extends AppCompatActivity {

    TextInputEditText nome;
    TextInputEditText peso;
    TextInputEditText altura;
    Date dtNascimento;
    RadioGroup radioGroupSexo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_iniciais);

//         nome findViewById(R.id.inputName);
//         peso findViewById(R.id.inputPeso);
//         altura findViewById(R.id.inputPeso);
//         dtNascimento findViewById(R.id.inputPeso);
//         radioGroupSexo findViewById(R.id.inputPeso);
    }
}
