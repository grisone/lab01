package com.example.testaplication.tarea4;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testaplication.R;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayList<Distro> distribuciones;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4_lista);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        poblarListado();

        DistrosAdapter adapter;
        adapter = new DistrosAdapter(this, distribuciones);

        ListView listView = (ListView) findViewById(R.id.lvItems);
        listView.setAdapter(adapter); // asignamos los datos
        listView.setOnItemClickListener(this); // // asignamos el escucha de eventos
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
    
    private void poblarListado() {
        distribuciones = new ArrayList<Distro>();

        // TODO pendiente de especificar que datos de las distribuciones vamos a empotrar y que datos vamos a cargar desde la web

        distribuciones.add(new Distro("Debian", R.drawable.debian, "1"));
        distribuciones.add(new Distro("Elementary", R.drawable.elementary, "1"));
        distribuciones.add(new Distro("Linux Mint", R.drawable.linux_mint, "1"));
        distribuciones.add(new Distro("Open SUSE", R.drawable.opensuse, "1"));
        distribuciones.add(new Distro("SlackWare", R.drawable.slackware, "1"));
        distribuciones.add(new Distro("Ubuntu", R.drawable.ubuntu, "1"));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Al hacer click sobre uno de los items del ListView mostramos los
        // datos en los TextView.
        TextView txtNombre = (TextView) findViewById(R.id.tvItemContent);
        TextView txtDetalle = (TextView) findViewById(R.id.tvItemField);

        Distro distro = distribuciones.get(position);

        txtNombre.setText(distro.getNombre());
        txtDetalle.setText(String.valueOf(position));


        Intent intent = new Intent(getApplicationContext(), DetalleActivity.class);
        intent.putExtra("distro",  distro);
        startActivity(intent);
        //return true;
    }


}
