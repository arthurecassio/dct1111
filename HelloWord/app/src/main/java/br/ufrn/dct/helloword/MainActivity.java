package br.ufrn.dct.helloword;

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

        TextView txtHello = findViewById(R.id.txtHello);
        txtHello.setText("Olá mundo!");

        EditText txtNome = findViewById(R.id.txtNome);
        Button btnHello = findViewById(R.id.btnHello);

        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensagem = "Olá "+txtNome.getText()+". Seja bem vindo!";
                txtHello.setText(mensagem);
            }
        });
    }
}