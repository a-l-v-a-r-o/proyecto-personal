package com.alpehe.huertovalenciano.vista;

import android.os.Bundle;

import com.alpehe.huertovalenciano.controlador.ControladorPrincipal;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import com.alpehe.huertovalenciano.databinding.ActivityVistaPlantaBinding;

public class VistaPlantaActivity extends AppCompatActivity {

    private ActivityVistaPlantaBinding binding;
    ControladorPrincipal c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        c = new ControladorPrincipal(this);

        binding = ActivityVistaPlantaBinding.inflate(getLayoutInflater());
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

        FloatingActionButton fabAnyadir = binding.fabAnyadir;
        fabAnyadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c.lanzarMainActivity();
            }
        });
        FloatingActionButton fabEditar = binding.fabEditar;
        fabEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c.lanzarEditarPlantaReturn();
            }
        });
    }
}