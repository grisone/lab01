package com.example.testaplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    String texto;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_option);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        texto = getIntent().getStringExtra("Texto");
        txt = (TextView) findViewById(R.id.txtSP);
        txt.setText(texto.toUpperCase());
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

}