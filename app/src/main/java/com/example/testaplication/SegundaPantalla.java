package com.example.testaplication;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundaPantalla extends AppCompatActivity {

    String texto;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);

        texto = getIntent().getStringExtra("Texto");
        txt = (TextView) findViewById(R.id.txtSP);
        txt.setText(texto.toUpperCase());
    }
}