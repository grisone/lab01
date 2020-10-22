package com.example.testaplication.tarea4;

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

import java.util.ArrayList;

public class DistrosAdapter extends ArrayAdapter {

    private Context contexto;
    private ArrayList<Distro> data;

    public DistrosAdapter(@NonNull Context context, ArrayList<Distro> data) {
        super(context, R.layout.activity_4_item, data);
        this.contexto = context;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(contexto);

        View item = inflater.inflate(R.layout.activity_4_item, null);

        ImageView imagen = (ImageView) item.findViewById(R.id.imgAnimal);
        imagen.setImageResource(data.get(position).getAno());

        TextView nombre = (TextView) item.findViewById(R.id.tvContent);
        nombre.setText(data.get(position).getNombre());

        TextView numCelda = (TextView) item.findViewById(R.id.tvField);
        numCelda.setText(String.valueOf(position));

        return item;
        //return super.getView(position, convertView, parent);
    }
}
