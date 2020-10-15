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

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

        int id =item.getItemId();
        switch (id){
            case android.R.id.home:
                // onBackPressed();

                //return true;
            finish();
        }
        return  super.onOptionsItemSelected(item);


        // super.onOptionsItemSelected(item);
    }


   /* public void vistaImagen(View view) {
        ImageView imagen = (ImageView) findViewById(R.id.imageView);
        ToggleButton boton = (ToggleButton)findViewById(R.id.toggleButton);
        if(boton.isChecked()){
            imagen.setVisibility(ImageView.VISIBLE);
        } else {
            imagen.setVisibility(ImageView.INVISIBLE);
        }
    }*/
}