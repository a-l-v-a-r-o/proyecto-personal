package com.alpehe.huertovalenciano;

import android.os.Bundle;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.alpehe.huertovalenciano.ui.main.SectionsPagerAdapter;

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
        fabAnyadir.setOnClickListener(view -> Snackbar.make(view, "Botón para añadir plantas", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        FloatingActionButton fabAjustes = findViewById(R.id.fabAjustes);
        fabAjustes.setOnClickListener(view -> Snackbar.make(view, "Botón para abrir las preferencias", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
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