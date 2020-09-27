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
        switch (opcion){
            case R.id.home:
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}