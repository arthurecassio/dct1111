package br.ufrn.dct.media;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperando elementos da UI
        Button btnMedia = findViewById(R.id.btnMedia);
        Button btnRecuperacao = findViewById(R.id.btnRecuperacao);
        TextView txtMensagem = findViewById(R.id.txtMensagem);
        EditText txtUnidade1 = findViewById(R.id.txtUnidade1);
        EditText txtUnidade2 = findViewById(R.id.txtUnidade2);
        EditText txtUnidade3 = findViewById(R.id.txtUnidade3);
        EditText txtRecuperacao = findViewById(R.id.txtRecuperacao);

        //Ajustando a UI
        btnRecuperacao.setEnabled(false);

        btnMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double nota1 = Double.parseDouble(txtUnidade1.getText().toString());
                double nota2 = Double.parseDouble(txtUnidade2.getText().toString());
                double nota3 = Double.parseDouble(txtUnidade3.getText().toString());

                Media media = new Media(nota1,nota2,nota3);
                txtMensagem.setText(media.verificarAprovacao());
                btnRecuperacao.setEnabled(true);
            }
        });

        btnRecuperacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double nota1 = Double.parseDouble(txtUnidade1.getText().toString());
                double nota2 = Double.parseDouble(txtUnidade2.getText().toString());
                double nota3 = Double.parseDouble(txtUnidade3.getText().toString());
                double notaRecuperacao = Double.parseDouble(txtRecuperacao.getText().toString());

                Media media = new Media(nota1,nota2,nota3);
                txtMensagem.setText(media.verificarAprovacaoRecuperacao(notaRecuperacao));
            }
        });


    }
}