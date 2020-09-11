package com.example.testaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int transversal = 0;
    private static int inicial;

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
        String valor2 = textView2.getText() + " :: " + ++inicial;
        textView2.setText(valor2);

        TextView textView3 =  findViewById(R.id.textView3);
        String valor3 = textView3.getText() + " :: " + ++transversal;
        textView3.setText(valor3);
    }

    public void abrirActividad(View view) {
        Toast.makeText(this, R.string.subtitulo1, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, DosActivity.class);
        startActivity(intent);
        //finish();
    }
}