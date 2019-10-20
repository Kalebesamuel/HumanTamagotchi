package com.mtec.humantamagotchiapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import com.mtec.humantamagotchiapp.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Opcao extends AppCompatActivity {

    private Button btPesquisa;
    private Button btDieta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcao);

        btPesquisa = findViewById(R.id.btPesquisa);
        btDieta = findViewById(R.id.btDieta);
    }

    public void callDefinirDieta(View view){
        Intent intent = new Intent(this, DefinirDieta.class);
        startActivity(intent);
    }

    public void callPesquisa(View view){
        Intent intent = new Intent(this, Pesquisa.class);
        startActivity(intent);
    }

}
