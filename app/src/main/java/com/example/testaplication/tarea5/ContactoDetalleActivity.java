package com.example.testaplication.tarea5;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testaplication.R;

public class ContactoDetalleActivity extends AppCompatActivity {

    Contacto contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto_detalle_vista);

        ActionBar barra = getSupportActionBar();
        barra.setDisplayHomeAsUpEnabled(true);
        barra.setTitle(R.string.verContacto);

        contacto = (Contacto) getIntent().getSerializableExtra("contacto");

        ImageView imgSexo = (ImageView) findViewById(R.id.imagen);
        TextView txtNombre = (TextView) findViewById(R.id.nombre);
        TextView txtPaterno = (TextView) findViewById(R.id.paterno);
        TextView txtMaterno = (TextView) findViewById(R.id.materno);
        TextView txtTelefono = (TextView) findViewById(R.id.telefono);

        imgSexo.setImageResource(contacto.getSexo().equals("F") ? R.drawable.woman : R.drawable.man);
        txtNombre.setText(contacto.getNombre());
        txtPaterno.setText(contacto.getPaterno());
        txtMaterno.setText(contacto.getMaterno());
        txtTelefono.setText(contacto.getTelefono());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contactos, menu);
        menu.findItem(R.id.eliminar).setVisible(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.eliminar:
                new AlertDialog.Builder(this)
                        .setTitle(R.string.removeContacto)
                        .setMessage("Estas por eliminar a " + contacto.getNombreCompleto() +"\n ¿ Continuar con la eliminacion ?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                if(eliminarContacto()){
                                    Toast.makeText(ContactoDetalleActivity.this, "Contacto Eliminado", Toast.LENGTH_SHORT).show();
                                    onBackPressed();
                                } else {
                                    Toast.makeText(ContactoDetalleActivity.this, "Error al Eliminar\nReintente", Toast.LENGTH_LONG).show();
                                }
                            }})
                        .setNegativeButton(android.R.string.no, null).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean eliminarContacto(){
        ContactoDataSource dataSource = new ContactoDataSource(this);
        dataSource.openDb();
        int retorno = dataSource.eliminarContacto(contacto);
        dataSource.closeDb();

        return (retorno == 1);
    }
}
