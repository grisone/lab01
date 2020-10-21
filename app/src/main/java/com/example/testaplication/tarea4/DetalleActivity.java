package com.example.testaplication.tarea4;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testaplication.R;

public class DetalleActivity extends AppCompatActivity {

    // TODO pendiente de formatear ambas vistas a un formato mas estandar o mas moderna la especificacion

    // TODO pendiente de agregar imagen, y mas datos desde las distribuciones

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_detalle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Distro distro = (Distro) getIntent().getSerializableExtra("distro");

        TextView txt1 = (TextView) findViewById(R.id.texto);
        TextView txt2 = (TextView) findViewById(R.id.texto2);

        txt1.setText(distro.getNombre());
        txt2.setText(distro.getDescripcion());
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
