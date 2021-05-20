package com.alpehe.huertovalenciano.vista;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
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

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alpehe.huertovalenciano.databinding.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VistaPlantaActivity extends AppCompatActivity {

    private ActivityVistaPlantaBinding binding;
    private ContentScrollingVistaPlantaBinding bindingContent;
    ControladorPrincipal c;
    ControladorMetodosGenerales cmg;
    ControladorDatos cDatos, cDatosS;
    RepositorioPlantas plantas;
    RepositorioPlantasSeleccionadas plantasS;

    Planta planta;
    PlantaSeleccionada plantaS;

    int num_iniciar;
    int pos;

    Toolbar toolbar;
    CollapsingToolbarLayout toolBarLayout;
    TextView especie, tipoVerdura, necHidricas, txtFSiembra,txtTipoVerdura;
    EditText fSiembra, fCosecha, notas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c = new ControladorPrincipal(this);

        Bundle extras = getIntent().getExtras();
        pos = extras.getInt("pos", 0);
        num_iniciar = extras.getInt("num_iniciar", 1);

        plantas = ((Aplicacion) getApplication()).plantas;
        cDatos = new ControladorDatos(this, plantas);
        planta = plantas.elemento(pos);

            plantasS = ((Aplicacion) getApplication()).plantasS;
            cDatosS = new ControladorDatos(this, plantasS);
            try{

            }catch (Exception ex){

            }

        iniciarVistas();

        if (num_iniciar == 1) {

            iniciarDatos();
            iniciarAcciones();
        }
        else if (num_iniciar == 2) {

            plantaS = plantasS.elemento(pos);

            iniciarDatosS();
            iniciarAccionesS();
        }


    }

    public void iniciarVistas(){
        c = new ControladorPrincipal(this);
        cmg = new ControladorMetodosGenerales();


     /*   toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolBarLayout= findViewById(R.id.toolbar_layout);*/


        binding = ActivityVistaPlantaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        toolBarLayout= binding.toolbarLayout;

        /*
        bindingContent = ContentScrollingVistaPlantaBinding.inflate(getLayoutInflater());
        setContentView(bindingContent.getRoot());
        especie = bindingContent.especie;
        txtFSiembra = bindingContent.txtFSiembra;
        fSiembra = bindingContent.fSiembra;
        fCosecha = bindingContent.fCosecha;
        txtTipoVerdura = bindingContent.txtTipoVerdura;
        tipoVerdura = bindingContent.tipoVerdura;
        necHidricas = bindingContent.necHidricas;
        notas = bindingContent.notas;
        */

        especie = findViewById(R.id.especie);
        txtFSiembra = findViewById(R.id.txtFSiembra);
        fSiembra = findViewById(R.id.fSiembra);
        fCosecha = findViewById(R.id.fCosecha);
        txtTipoVerdura = findViewById(R.id.txtTipoVerdura);
        tipoVerdura = findViewById(R.id.tipoVerdura);
        necHidricas = findViewById(R.id.necHidricas);
        notas = findViewById(R.id.notas);

    }

    public void iniciarDatos(){

        toolBarLayout.setTitle(planta.getNombre());

        especie.setText(planta.getEspecie());
        fSiembra.setText(planta.getFecha_siembra_recomendada());
        fCosecha.setText(planta.getFecha_cosecha());
        /*tipoVerdura.setText(planta.getTipoVerudra().getTexto());*/
        /*necHidricas.setText(planta.getNecesidadesHidricas().getTexto());*/
        notas.setText(planta.getNotas());

        fSiembra.setFocusable(false);
        fCosecha.setFocusable(false);
        notas.requestFocus();
    }



    public void iniciarAcciones(){
        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plantaS = new PlantaSeleccionada(
                        planta.getNombre(),
                        null, null, null,null,null,
                        planta.getFecha_siembra_recomendada(),planta.getFecha_cosecha(),
                        planta.getNotas());

                cDatosS.añadirS(plantaS);

                AlertDialog.Builder builder = new AlertDialog.Builder(VistaPlantaActivity.this);
                builder.setTitle("¿Lo has sembrado hoy?");
                builder.setIcon(android.R.drawable.ic_menu_day);
                builder.setMessage("Añadir la fecha de siembra");
                builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id1) {

                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                            Date date = new Date();
                            plantaS.setFecha_siembra(" "+formatter.format(date));

                        c.lanzarMainActivity();
                    } });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id2) {
                        dialog.cancel();
                        c.lanzarMainActivity();
                    } });
                builder.show();
            }
        });
    }

    public void iniciarDatosS(){

        toolBarLayout.setTitle(plantaS.getNombre());
        toolBarLayout.setExpandedTitleColor(Color.YELLOW);

        if(!planta.getFecha_siembra_recomendada().equals(plantaS.getFecha_siembra())){
            txtFSiembra.setText("Fecha sembrado:");
        }

        fSiembra.setText(plantaS.getFecha_siembra());
        fCosecha.setText(plantaS.getFecha_cosecha());
        txtTipoVerdura.setVisibility(View.GONE);
        tipoVerdura.setVisibility(View.GONE);
        /*necHidricas.setText(plantaS.getNecesidadesHidricas().getTexto());*/
        notas.setText(plantaS.getNotas());
    }

    public void iniciarAccionesS(){
        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!plantaS.getNombre().contains("Finalizado")) {
                    plantaS.setNombre(plantaS.getNombre() + ":Finalizado");

                    AlertDialog.Builder builder = new AlertDialog.Builder(VistaPlantaActivity.this);
                    builder.setTitle("¿Lo has cosechado hoy?");
                    builder.setIcon(android.R.drawable.ic_menu_day);
                    builder.setMessage("Añadir la fecha de cosecha");
                    builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id1) {

                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                            Date date = new Date();
                            plantaS.setFecha_cosecha(" " + formatter.format(date));

                            c.lanzarMainActivity();
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id2) {
                            dialog.cancel();
                            c.lanzarMainActivity();
                        }
                    });
                    builder.show();
                }else{
                    cmg.ToastLargo(VistaPlantaActivity.this,"Ya se ha cosechado");
                }
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
        if (num_iniciar == 1) {

           if (id == R.id.editar) {

               String getText = notas.getText().toString();

               if(!planta.getNotas().equals(getText)){
                   planta.setNotas(notas.getText().toString());
                   cmg.ToastCorto(this,"Editado");
               }
               cDatos.guardar(pos, planta);
               return true;
           }
       }
        if (num_iniciar == 2) {

        if (id == R.id.eliminar) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("ATENCIÓN");
            builder.setIcon(android.R.drawable.ic_menu_delete);
            builder.setMessage("¿Seguro que quieres borrar esta verdura de tu lista?");
            builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id1) {
                    cDatosS.borrarS(pos);
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
            if(!plantaS.getNotas().equals(notas.getText().toString())){
                planta.setNotas(notas.getText().toString());
                cmg.ToastCorto(this,"Editado");
            }
            if(!plantaS.getFecha_cosecha().equals(fCosecha.getText().toString())){
                plantaS.setFecha_cosecha(fCosecha.getText().toString());
                cmg.ToastCorto(this,"Editado");
            }
            if(!plantaS.getFecha_siembra().equals(fSiembra.getText().toString())){
                plantaS.setFecha_siembra(fSiembra.getText().toString());
                cmg.ToastCorto(this,"Editado");
            }
            cDatosS.guardar(pos, plantaS);
            return true;
        }

    }
        return super.onOptionsItemSelected(item);
    }
}