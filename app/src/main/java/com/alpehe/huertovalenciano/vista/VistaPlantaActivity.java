package com.alpehe.huertovalenciano.vista;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.alpehe.huertovalenciano.R;
import com.alpehe.huertovalenciano.commons.AdaptadorPlantas;
import com.alpehe.huertovalenciano.commons.Aplicacion;
import com.alpehe.huertovalenciano.commons.ControladorDatos;
import com.alpehe.huertovalenciano.commons.ControladorMetodosGenerales;
import com.alpehe.huertovalenciano.commons.ControladorPrincipal;
import com.alpehe.huertovalenciano.datos.RepositorioPlantas;
import com.alpehe.huertovalenciano.datos.RepositorioPlantasSeleccionadas;
import com.alpehe.huertovalenciano.modelo.Planta;
import com.alpehe.huertovalenciano.modelo.PlantaSeleccionada;
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
    ControladorDatos cDatos, cDatosS;
    RepositorioPlantas plantas;
    RepositorioPlantasSeleccionadas plantasS;

    Planta planta;
    PlantaSeleccionada plantaS;

    int num_iniciar;
    int pos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        c = new ControladorPrincipal(this);

        Bundle extras = getIntent().getExtras();
        pos = extras.getInt("pos", 0);
        num_iniciar = extras.getInt("num_iniciar", 1);

        plantas = ((Aplicacion) getApplication()).plantas;
        cDatos = new ControladorDatos(this, plantas);
        planta = plantas.elemento(pos);

            plantasS = ((Aplicacion) getApplication()).plantasS;
            cDatosS = new ControladorDatos(this, plantasS);

        if (num_iniciar == 1) {
            planta = plantas.elemento(pos);

            iniciarVistasDatos1();
            iniciarAcciones1();
        }
        else if (num_iniciar == 2) {
            plantaS = plantasS.elemento(pos);

            iniciarVistasDatos2();
            iniciarAcciones2();
        }


    }

    public void iniciarVistasDatos1(){
        c = new ControladorPrincipal(this);
        cmg = new ControladorMetodosGenerales();

        binding = ActivityVistaPlantaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(planta.getNombre());


    }

    public void iniciarVistasDatos2(){
        c = new ControladorPrincipal(this);
        cmg = new ControladorMetodosGenerales();

        binding = ActivityVistaPlantaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(plantaS.getNombre());
    }

    public void iniciarAcciones1(){
        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plantaS = new PlantaSeleccionada(
                        planta.getNombre(),
                        null, null, null,null,null,
                        planta.getFecha_siembra_recomendada(),planta.getFecha_trasplante(),
                        planta.getNotas());

                cDatosS.añadirS(plantaS);


                c.lanzarMainActivity();
            }
        });
    }

    public void iniciarAcciones2(){
        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cDatos.borrar(pos);
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
                    cDatos.borrar(pos);
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