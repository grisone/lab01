package com.example.testaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = (EditText) findViewById(R.id.edtMA);
        btn = (Button) findViewById(R.id.btnMA);
    }

    //MÉTODOS
    public void cambiarPantalla(View view){
        Context contexto = getApplicationContext();
        String edtTexto = edt.getText().toString();

        if(edtTexto.isEmpty()){
            String mensaje = "DEBE INGRESAR UN TEXTO";
            Toast.makeText(contexto, mensaje, Toast.LENGTH_SHORT).show();
        }else{
            Intent texto = new Intent(contexto, SegundaPantalla.class);
            texto.putExtra("Texto", edtTexto);
            startActivity(texto);
        }

    }
}