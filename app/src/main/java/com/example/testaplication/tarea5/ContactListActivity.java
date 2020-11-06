package com.example.testaplication.tarea5;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testaplication.R;
import com.example.testaplication.tarea4.DetalleActivity;
import com.example.testaplication.tarea4.Distro;

import java.util.List;

public class ContactListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ContactoDataSource dataSource;
    List<Contacto> listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        ActionBar barra = getSupportActionBar();
        barra.setDisplayHomeAsUpEnabled(true);
        barra.setTitle("Lista de Contactos");
    }

    @Override
    protected void onResume() {
        super.onResume();

        dataSource = new ContactoDataSource(this);

        dataSource.openDb();
        listaContactos = dataSource.getListaContactos();
        dataSource.closeDb();

        ContactoAdapter adapter = new ContactoAdapter(this, listaContactos);

        ListView listView = (ListView) findViewById(R.id.listado);
        listView.setAdapter(adapter); // asignamos los datos
        listView.setOnItemClickListener(this); // // asignamos el escucha de eventos
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contactos, menu);
        menu.findItem(R.id.agregar).setVisible(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.agregar:
                startActivity(new Intent(getApplicationContext(), AgregarContactoActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Contacto contacto = listaContactos.get(position);

        Intent intent = new Intent(getApplicationContext(), ContactoDetalleActivity.class);
        intent.putExtra("contacto", contacto);
        startActivity(intent);
    }
}
