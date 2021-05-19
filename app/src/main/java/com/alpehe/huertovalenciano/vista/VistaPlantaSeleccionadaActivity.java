package com.alpehe.huertovalenciano.vista;

import android.os.Bundle;

import com.alpehe.huertovalenciano.controlador.ControladorPrincipal;
import com.alpehe.huertovalenciano.controlador.ControladorMetodosGenerales;
import com.github.clans.fab.FloatingActionMenu;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import com.alpehe.huertovalenciano.databinding.ActivityVistaPlantaSeleccionadaBinding;

public class VistaPlantaSeleccionadaActivity extends AppCompatActivity {

    private ActivityVistaPlantaSeleccionadaBinding binding;

    ControladorPrincipal c;
    ControladorMetodosGenerales cMetodos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        c = new ControladorPrincipal(this);

        binding = ActivityVistaPlantaSeleccionadaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        iniciarBotonesFlotantes();
    }

    public void iniciarBotonesFlotantes(){
        FloatingActionMenu faMenu = binding.faMenu;
        faMenu.setClosedOnTouchOutside(true);

        FloatingActionButton fabBorrar = binding.fabBorrar;
        fabBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cMetodos.dialogoBorrar(VistaPlantaSeleccionadaActivity.this, 0);
            }
        });
        FloatingActionButton fabEditar = binding.fabEditar;
        fabEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c.lanzarEditarPlantaReturn();
            }
        });
        FloatingActionButton fabTerminado = binding.fabTerminado;
        fabTerminado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c.lanzarEditarPlantaReturn();
            }
        });
    }
}