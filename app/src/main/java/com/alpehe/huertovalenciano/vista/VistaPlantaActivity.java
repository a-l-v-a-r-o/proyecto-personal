package com.alpehe.huertovalenciano.vista;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.alpehe.huertovalenciano.R;
import com.alpehe.huertovalenciano.commons.AdaptadorPlantas;
import com.alpehe.huertovalenciano.commons.Aplicacion;
import com.alpehe.huertovalenciano.commons.ControladorMetodosGenerales;
import com.alpehe.huertovalenciano.commons.ControladorPrincipal;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.alpehe.huertovalenciano.databinding.ActivityVistaPlantaBinding;

public class VistaPlantaActivity extends AppCompatActivity {

    private ActivityVistaPlantaBinding binding;
    ControladorPrincipal c;
    ControladorMetodosGenerales cmg;

    int num_iniciar;

    private RecyclerView recyclerView;
    public AdaptadorPlantas adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent vPlanta = getIntent();
        num_iniciar = vPlanta.getIntExtra("num_iniciar", 1);

        if (num_iniciar == 1) {
            iniciarVistasDatos1();
            iniciarAcciones1();
        }
        else if (num_iniciar == 2) {
           /* iniciarVistasDatos2();
            iniciarAcciones2();*/
        }

        adaptador = ((Aplicacion) getApplication()).adaptador;
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptador);
    }

    public void iniciarVistasDatos1(){
        c = new ControladorPrincipal(this);
        cmg = new ControladorMetodosGenerales();

        binding = ActivityVistaPlantaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());


    }

    public void iniciarAcciones1(){
        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                c.lanzarMainActivity();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (num_iniciar == 1) {
            getMenuInflater().inflate(R.menu.menu_vista_planta, menu);
        }
           else if (num_iniciar == 2) {
                getMenuInflater().inflate(R.menu.menu_vista_planta_seleccionada, menu);
            }

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (num_iniciar == 2) {

           if (id == R.id.editar) {
               cmg.ToastCorto(this,"Editado");
               return true;
           }
       }
        if (num_iniciar == 1) {

        if (id == R.id.eliminar) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("ATENCIÓN");
            builder.setIcon(android.R.drawable.ic_menu_delete);
            builder.setMessage("¿Seguro que quieres borrar esta verdura de tu lista?");
            builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id1) {
                    // todo eliminar el item del array de objetos, qué será el mismo número que la posicion de la lista
                    c.lanzarMainActivity();
                } });
            builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id2) {
                    dialog.cancel();
                } });
            builder.show();
            return true;
        }
        if (id == R.id.editar) {
            cmg.ToastCorto(this,"Editado");
            return true;
        }

    }
        return super.onOptionsItemSelected(item);
    }
}