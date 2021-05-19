package com.alpehe.huertovalenciano.vista;

import android.os.Bundle;

import com.alpehe.huertovalenciano.R;
import com.alpehe.huertovalenciano.commons.ControladorPrincipal;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.alpehe.huertovalenciano.vista.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    ControladorPrincipal principal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        principal = new ControladorPrincipal(MainActivity.this);

        iniciarVistas();
        iniciarBotonesFlotantes();

    }

    public void iniciarVistas(){

    }

    public void iniciarBotonesFlotantes(){
        FloatingActionMenu faMenu = findViewById(R.id.faMenu);
        faMenu.setClosedOnTouchOutside(true);


        FloatingActionButton fabAnyadir = findViewById(R.id.fabAnyadir);
        fabAnyadir.setOnClickListener(view -> {
            principal.lanzarVistaPlanta(1);
        });


        FloatingActionButton fabAjustes = findViewById(R.id.fabAjustes);
        fabAjustes.setOnClickListener(view ->{
            principal.lanzarAjustes();
        });
    }
}