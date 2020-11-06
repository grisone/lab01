package com.example.testaplication.tarea5;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testaplication.R;

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
                Contacto contacto = validarContacto();
                if (contacto!=null){
                    guardarContacto(contacto);
                    Toast.makeText(getApplicationContext(), "Datos guardados correctamente", Toast.LENGTH_LONG).show();
                    onBackPressed();
                }else{
                    Toast.makeText(getApplicationContext(), "Debe ingresar todos los datos", Toast.LENGTH_LONG).show();
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void cambiarSexo(View view){
        int id = view.getId();
        if(((CheckBox)view).isChecked()){
            CheckBox chkMan = (CheckBox) findViewById(R.id.hombre);
            CheckBox chkWom = (CheckBox) findViewById(R.id.mujer);
            if(id == R.id.mujer){
                chkMan.setChecked(false);
            } else {
                chkWom.setChecked(false);
            }
        }
    }

    private Contacto validarContacto(){
        EditText edtNombre = (EditText) findViewById(R.id.nombres);
        EditText edtPaterno = (EditText) findViewById(R.id.ap_paterno);
        EditText edtMaterno = (EditText) findViewById(R.id.ap_materno);
        EditText edtFono = (EditText) findViewById(R.id.fono);
        CheckBox chkMan = (CheckBox) findViewById(R.id.hombre);
        CheckBox chkwom = (CheckBox) findViewById(R.id.mujer);

        if(!edtNombre.getText().toString().isEmpty() &&
                !edtPaterno.getText().toString().isEmpty() &&
                !edtMaterno.getText().toString().isEmpty() &&
                !edtFono.getText().toString().isEmpty() &&
                (chkMan.isChecked() | chkwom.isChecked())
        ) {

            Contacto contacto = new Contacto();
            contacto.setSexo(chkMan.isChecked()?"M":"F");
            contacto.setNombre(edtNombre.getText().toString());
            contacto.setPaterno(edtPaterno.getText().toString());
            contacto.setMaterno(edtMaterno.getText().toString());
            contacto.setTelefono(edtFono.getText().toString());

            return contacto;
        }
        return null;
    }

    private void guardarContacto(Contacto contacto){
        ContactoDataSource dataSource = new ContactoDataSource(this);
        dataSource.openDb();
        dataSource.insertarContacto(contacto);
        dataSource.closeDb();
    }
}
