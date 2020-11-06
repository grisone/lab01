package com.example.testaplication.tarea5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testaplication.R;
import com.example.testaplication.SegundaPantalla;

public class AgregarContactoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto_edicion);

        ActionBar barra = getSupportActionBar();
        barra.setDisplayHomeAsUpEnabled(true);
        barra.setTitle(R.string.addContacto);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contactos, menu);
        menu.findItem(R.id.guardar).setVisible(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.guardar:
                if (validarContacto()){
                    Toast.makeText(getApplicationContext(), "Datos guardados correctamente", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Debe ingresar todos los datos", Toast.LENGTH_LONG).show();

                }

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean validarContacto(){
        boolean valido = false;
        EditText edtNombre = (EditText) findViewById(R.id.nombres);
        EditText edtPaterno = (EditText) findViewById(R.id.ap_paterno);
        EditText edtMaterno = (EditText) findViewById(R.id.ap_materno);
        EditText edtFono = (EditText) findViewById(R.id.fono);



        if(!edtNombre.getText().toString().isEmpty() &&
                !edtPaterno.getText().toString().isEmpty() &&
                !edtMaterno.getText().toString().isEmpty() &&
                !edtFono.getText().toString().isEmpty()

        ){
            valido=true;
        }
    return valido;
    }

}
