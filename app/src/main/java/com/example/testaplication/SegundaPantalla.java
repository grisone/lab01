package com.example.testaplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SegundaPantalla extends AppCompatActivity {


    ListView lvelementos;
    String distros = "{\"Distros\":[{\"Nombre\":\"CentOS\",\"Fecha\":\"1998\",\"Licencia\":\"Libre\"}," +
            "{\"Nombre\":\"Debian\",\"Fecha\":\"1998\",\"Licencia\":\"Libre\"}," +
            "{\"Nombre\":\"Fedora\",\"Fecha\":\"1998\",\"Licencia\":\"Libre\"}," +
            "{\"Nombre\":\"LinuxMint\",\"Fecha\":\"1998\",\"Licencia\":\"Libre\"}," +
            "{\"Nombre\":\"Ubuntu\",\"Fecha\":\"1998\",\"Licencia\":\"Libre\"}]}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);

         lvelementos = (ListView)  findViewById(R.id.lvdistrosSP);


        try {
            cargarLista();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //metodos
    private void cargarLista() throws JSONException {
        Context contexto = getApplicationContext();
        ArrayList<String> listaDistros = new ArrayList<>();
        JSONObject objetoJSON = new JSONObject(distros);
        JSONArray arrayJSON = objetoJSON.getJSONArray("Distros");
        for( int i = 0; i < arrayJSON.length(); i++){
            try {
                JSONObject json = arrayJSON.getJSONObject(i);
                //SE OBTiENE EL DATO Y SE GUARDA EN LA LISTA.
                listaDistros.add(json.getString("Nombre") + ";" + json.getString("Fecha")
                        + ";" + json.getString("Licencia"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listaDistros);
        lvelementos.setAdapter(adapter);
        capturarFila(listaDistros);

    }


    public void capturarFila(final ArrayList<String > filas){
        lvelementos.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Context contexto = getApplicationContext();
                String fila = String.valueOf(lvelementos.getItemAtPosition(position));
                Toast.makeText(contexto, "fila :"+ fila, Toast.LENGTH_LONG ).show();

                Intent intent = new Intent(view.getContext(), DetalleActivity.class);
                intent.putExtra("Fila", fila);
                //startActivity(intent);
                startActivityForResult(intent, 0);
            }
        });

    }

}