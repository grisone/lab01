package com.example.testaplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String clave = "umayor";
    private EditText edtTexto ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setHomeButtonEnabled(true);
        edtTexto = (EditText) findViewById(R.id.edtMA);

    }


    public void capturarTexto(View view){
        Context contexto = getApplicationContext();
        String psw = edtTexto.getText().toString();
        System.out.println("contraseña :" +psw);
        String mensaje = "sin mensaje";
        if(psw.equals(clave)){
            mensaje = "estoy en el IF";
            Intent intent = new Intent(getApplicationContext(), SegundaPantalla.class);
            //intent.putExtra();
            System.out.println(mensaje);
            startActivity(intent);


        }else{
            mensaje= "estoy e el else";
            System.out.println(mensaje);
            Toast.makeText(contexto, mensaje, Toast.LENGTH_SHORT).show();
        }

    }



    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
        // original
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int opcion = item.getItemId();
        String mensajeria = "";
        switch (opcion){
            case android.R.id.home:
                mensajeria = "Opcion retornar";
                break;
            case R.id.home:
                mensajeria = "Opcion casita";
                break;
            case R.id.menu_opcion_100:
                mensajeria = "Vamos a ver la pajjjina";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.example.org")));
                break;
            case R.id.menu_opcion_200:
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                intent.putExtra("Texto", "Vengo desde opcion");
                startActivity(intent);
                return true;


            case R.id.menu_opcion_900:
                finish();
                return true;

            default:
                mensajeria = "Sin Opcion";
        }

        Toast.makeText(getApplicationContext(), mensajeria, Toast.LENGTH_SHORT).show();

        return true;
        //return super.onOptionsItemSelected(item);
    }

    public void cambiarPantalla(View view){
        EditText edt = (EditText) findViewById(R.id.edtMA);

        Context contexto = getApplicationContext();
        String edtTexto = edt.getText().toString();

        if(edtTexto.isEmpty()){
            String mensaje = "DEBE INGRESAR UN TEXTO";
            Toast.makeText(contexto, mensaje, Toast.LENGTH_SHORT).show();
        }else{
            Intent texto = new Intent(contexto, SegundaPantalla.class);
            texto.putExtra("Texto", edtTexto);
            startActivity(texto);
        }

    }

     */
}