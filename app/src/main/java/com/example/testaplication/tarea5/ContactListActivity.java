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

import java.util.List;

public class ContactListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ContactoDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        ActionBar barra = getSupportActionBar();
        barra.setDisplayHomeAsUpEnabled(true);
        barra.setTitle("Lista de Contactos");


        dataSource = new ContactoDataSource(this);
        dataSource.openDb();
        List<Contacto> listaContactos = dataSource.getListaContactos();
        dataSource.closeDb();

/*
        distroDataSource = new DistroDataSource(this);
        distroDataSource.openDb();
        distroDataSource.closeDb();
*/

        ContactoAdapter adapter = new ContactoAdapter(this, listaContactos);

        ListView listView = (ListView) findViewById(R.id.listado);
        listView.setAdapter(adapter); // asignamos los datos
        listView.setOnItemClickListener(this); // // asignamos el escucha de eventos
    }

/*
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        if (disableCheckBox) {
            menu.removeItem(R.id.Done);
        }
        MenuItem searchItem = menu.findItem(R.id.menu_search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint(getResources().getString(R.string.search_hint));
        if (Utils.hasICS()) {
            searchItem.collapseActionView();
        }
        searchView.setOnQueryTextListener(this);
        searchView.setIconified(true);
        return super.onCreateOptionsMenu(menu);
        menu.add(0, MENU_EDIT, Menu.NONE, getString(R.string.menu_action_edit)).setIcon(R.drawable.ic_action_edit).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(0, MENU_DELETE, Menu.NONE, getString(R.string.menu_action_delete)).setIcon(R.drawable.ic_action_delete).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onPrepareOptionsMenu(menu);
        return true;
    }
*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contactos, menu);
        menu.findItem(R.id.agregar).setVisible(true);
        //menu.removeItem(R.id.menu_eliminar);
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
        String mensaje = "Posicion [" + String.valueOf(position) + "] largo[" + String.valueOf(id) + "]";
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
    }
}
