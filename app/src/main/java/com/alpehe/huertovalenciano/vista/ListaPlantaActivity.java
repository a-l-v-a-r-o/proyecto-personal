package com.alpehe.huertovalenciano.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.alpehe.huertovalenciano.R;
import com.alpehe.huertovalenciano.commons.AdaptadorPlantas;
import com.alpehe.huertovalenciano.commons.Aplicacion;
import com.alpehe.huertovalenciano.commons.ControladorDatos;
import com.alpehe.huertovalenciano.datos.RepositorioPlantas;
import com.alpehe.huertovalenciano.datos.RepositorioPlantasSeleccionadas;

public class ListaPlantaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public AdaptadorPlantas adaptador;
    public ControladorDatos cDatos;
    private RepositorioPlantas plantas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_planta);

        plantas = ((Aplicacion) getApplication()).getPlantas();
        cDatos = new ControladorDatos(this, plantas);

        adaptador = ((Aplicacion) getApplication()).adaptador;
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptador);
        adaptador.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = recyclerView.getChildAdapterPosition(v);
                cDatos.mostrar(pos, 1);
            }
        });
    }


}