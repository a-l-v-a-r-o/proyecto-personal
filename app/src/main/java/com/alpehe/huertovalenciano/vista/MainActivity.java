package com.alpehe.huertovalenciano.vista;

import android.os.Bundle;
import android.view.View;

import com.alpehe.huertovalenciano.R;
import com.alpehe.huertovalenciano.controlador.ControladorPrincipal;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.alpehe.huertovalenciano.vista.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        FloatingActionMenu faMenu = findViewById(R.id.faMenu);
        faMenu.setClosedOnTouchOutside(true);


        FloatingActionButton fabAnyadir = findViewById(R.id.fabAnyadir);
        fabAnyadir.setOnClickListener(view -> {
            ControladorPrincipal principal = new ControladorPrincipal(MainActivity.this);
            principal.lanzarRiego();
            Snackbar.make(view, "Botón para añadir plantas", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        });


        FloatingActionButton fabAjustes = findViewById(R.id.fabAjustes);
        fabAjustes.setOnClickListener(view ->{
            ControladorPrincipal principal = new ControladorPrincipal(MainActivity.this);
            principal.lanzarAjustes();
            Snackbar.make(view, "Botón para abrir los ajustes", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        });
    }

    public void Riego(View view) {
        ControladorPrincipal principal = new ControladorPrincipal(this);
        principal.lanzarRiego();
    }

    /*@Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true; *//** true -> el menú ya está visible *//*
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.acercaDe) {
            *//*lanzarAcercaDe(null);*//*
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}