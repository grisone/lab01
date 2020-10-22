package com.example.testaplication.tarea4;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testaplication.R;

public class DetalleActivity extends AppCompatActivity {

    // TODO pendiente de formatear ambas vistas a un formato mas estandar o mas moderna la especificacion

    // TODO pendiente de agregar imagen, y mas datos desde las distribuciones

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_detalle);

        Distro distro = (Distro) getIntent().getSerializableExtra("distro");

        ActionBar barra = getSupportActionBar();
        barra.setDisplayHomeAsUpEnabled(true);
        barra.setTitle(distro.getNombre());

        ImageView imagen = (ImageView) findViewById(R.id.imagen);
        TextView txtTitulo = (TextView) findViewById(R.id.textTitulo);
        TextView txtAno = (TextView) findViewById(R.id.textLanzamiento);
        TextView txtPaquete = (TextView) findViewById(R.id.textPaquete);
        TextView txtDetalle = (TextView) findViewById(R.id.textDetalle);

        imagen.setImageResource(distro.getImagen());
        txtTitulo.setText(distro.getNombre());
        txtDetalle.setText(distro.getDescripcion());
        txtAno.setText(distro.getLanzamiento());
        txtPaquete.setText(distro.getPaquete());

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
