package br.ufrn.dct.media2024;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.ufrn.dct.media2024.model.MediaParcial;

public class Aprovacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprovacao);

        //Capturando elementos da Tela
        EditText txtUnidade1 = findViewById(R.id.txtUnidade1);
        EditText txtUnidade2 = findViewById(R.id.txtUnidade2);
        EditText txtUnidade3 = findViewById(R.id.txtUnidade3);
        Button btnVerAprovacao = findViewById(R.id.btnVerAprovacao);
        TextView txvMensagem = findViewById(R.id.txvMensagem);

        btnVerAprovacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaParcial mediaParcial = new MediaParcial();
                mediaParcial.setNota_unidade_1(Double.parseDouble(txtUnidade1.getText().toString()));
                mediaParcial.setNota_unidade_2(Double.parseDouble(txtUnidade2.getText().toString()));
                mediaParcial.setNota_unidade_3(Double.parseDouble(txtUnidade3.getText().toString()));
                txvMensagem.setText(mediaParcial.verificarAprovacao());
            }
        });

    }
}