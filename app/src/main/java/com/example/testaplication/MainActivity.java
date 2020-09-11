package com.example.testaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static int transversal = 0;

    private int inicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicial = 0;
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView textView2 =  findViewById(R.id.textView2);
        String valor = textView2.getText() + " :: " + ++inicial;
        textView2.setText(valor);

        TextView textView3 =  findViewById(R.id.textView3);
        String valor2 = textView3.getText() + " :: " + ++transversal;
        textView3.setText(valor);
    }

    public void abrirActividad(View view) {
        Toast.makeText(this, R.string.subtitulo1, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, DosActivity.class);
        startActivity(intent);
        //finish();
    }
}