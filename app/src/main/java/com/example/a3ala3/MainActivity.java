package com.example.a3ala3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirActividad(View view) {
        Toast.makeText(this, "Nadi de nadi", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, DosActivity.class);
        startActivity(intent);
        //finish();
        //Toast.makeText(this, "Terminé", Toast.LENGTH_LONG).show();
    }
}