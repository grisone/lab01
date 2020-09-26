package com.example.testaplication;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaPantalla extends AppCompatActivity {

    String texto;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        texto = getIntent().getStringExtra("Texto");
        txt = (TextView) findViewById(R.id.txtSP);
        txt.setText(texto.toUpperCase());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // getMenuInflater().inflate(R.menu.main, menu);
        // return true;
        // original
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int opcion = item.getItemId();
        String mensajeria = "";
        switch (opcion){
            case android.R.id.home:
                return super.onOptionsItemSelected(item);

            case R.id.home:
                mensajeria = "Opcion casita";
                break;
            case R.id.menu_opcion_100:
                mensajeria = "Opcion 100";
                break;
            default:
                mensajeria = "Sin Opcion";
        }

        Toast.makeText(getApplicationContext(), mensajeria, Toast.LENGTH_SHORT).show();

        return true;
        //return super.onOptionsItemSelected(item);
    }



}