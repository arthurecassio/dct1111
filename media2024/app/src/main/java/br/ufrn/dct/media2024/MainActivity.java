package br.ufrn.dct.media2024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Criando as Intents
        Intent actAprovacao = new Intent(this,Aprovacao.class);

        //Adicionando Eventos
        Button btnAprovacao = findViewById(R.id.btnAprovacao);
        Button btnRecuperacao = findViewById(R.id.btnRecuperacao);



        btnAprovacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(actAprovacao);
            }
        });

    }
}