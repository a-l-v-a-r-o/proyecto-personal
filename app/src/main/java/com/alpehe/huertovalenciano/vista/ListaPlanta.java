package com.alpehe.huertovalenciano.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.alpehe.huertovalenciano.R;
import com.alpehe.huertovalenciano.commons.AdaptadorPlantas;
import com.alpehe.huertovalenciano.commons.Aplicacion;

public class ListaPlanta extends AppCompatActivity {

    private RecyclerView recyclerView;
    public AdaptadorPlantas adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_planta);

        adaptador = ((Aplicacion) getApplication()).adaptador;
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptador);
    }
}