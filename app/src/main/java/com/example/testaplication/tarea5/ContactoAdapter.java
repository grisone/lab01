package com.example.testaplication.tarea5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.testaplication.R;

import java.util.List;

public class ContactoAdapter extends ArrayAdapter {

    private Context contexto;
    private List<Contacto> datos;

    public ContactoAdapter(@NonNull Context context, List<Contacto> data) {
        super(context, R.layout.activity_contact_item_detail, data);
        this.contexto = context;
        this.datos = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(contexto);

        View item = inflater.inflate(R.layout.activity_contact_item_detail, null);

        Contacto persona = datos.get(position);

        ImageView imagen = (ImageView) item.findViewById(R.id.imagen);
        imagen.setImageResource(persona.getSexo().equals("F")? R.drawable.woman_ico : R.drawable.man_ico);

        TextView nombre = (TextView) item.findViewById(R.id.nombre);
        nombre.setText(persona.getNombreCompleto());

        TextView numero = (TextView) item.findViewById(R.id.telefono);
        numero.setText(persona.getTelefono());

        return item;
    }
}
