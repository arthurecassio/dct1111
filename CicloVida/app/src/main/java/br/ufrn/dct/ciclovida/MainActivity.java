package br.ufrn.dct.ciclovida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //TAG do Log
    protected static final String TAG = "Ciclo_Vida";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, getLocalClassName() + ".onCreate() chamado com Bundle: "+savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, getLocalClassName() + ".onStart() chamado.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, getLocalClassName() + ".onRestart() chamado.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, getLocalClassName() + ".onStop() chamado.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, getLocalClassName() + ".onPause() chamado.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, getLocalClassName() + ".onResume() chamado.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, getLocalClassName() + ".onDestroy() chamado.");
    }

}