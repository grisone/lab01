package com.example.testaplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String texto = getIntent().getStringExtra("Texto");
        Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.secondary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        onBackPressed();

        return true;// super.onOptionsItemSelected(item);
    }


    public void vistaImagen(View view) {
        ImageView imagen = (ImageView) findViewById(R.id.imageView);
        ToggleButton boton = (ToggleButton)findViewById(R.id.toggleButton);
        if(boton.isChecked()){
            imagen.setVisibility(ImageView.VISIBLE);
        } else {
            imagen.setVisibility(ImageView.INVISIBLE);
        }
    }
}