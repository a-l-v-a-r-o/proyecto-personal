package com.alpehe.huertovalenciano.commons;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import androidx.core.content.FileProvider;

import com.alpehe.huertovalenciano.BuildConfig;
import com.alpehe.huertovalenciano.datos.ListaPlantasSeleccionadas;
import com.alpehe.huertovalenciano.vista.ListaPlantaActivity;
import com.alpehe.huertovalenciano.vista.MainActivity;
import com.alpehe.huertovalenciano.vista.VistaPlantaActivity;
import com.alpehe.huertovalenciano.vista.AjustesActivity;
import com.alpehe.huertovalenciano.vista.BotonesActivity;

import java.io.File;

public class ControladorPrincipal {

    private Activity vActividad;

    public ControladorPrincipal(Activity pActividad){
        this.vActividad = pActividad;
    }

    public void lanzarMainActivity(){
        Intent main = new Intent(vActividad, MainActivity.class);
        vActividad.startActivity(main);
    }

    public void lanzarListaPlantas(){
        Intent plantas = new Intent(vActividad, ListaPlantaActivity.class);
        vActividad.startActivity(plantas);
    }
    public Intent lanzarListaPlantasReturn(){
        Intent plantas = new Intent(vActividad, ListaPlantaActivity.class);
        return plantas;
    }

    public void lanzarAjustes(){
        Intent ajustes = new Intent(vActividad, AjustesActivity.class);
        vActividad.startActivity(ajustes);
    }
    public Intent lanzarAjustesReturn(){
        Intent ajustes = new Intent(vActividad, AjustesActivity.class);
        return ajustes;
    }

    public void lanzarAcercaDe(){
        /*Intent acercaDe = new Intent(vActividad, AcercaDeActivity.class);
        vActividad.startActivity(acercaDe);*/
    }


    public void Compartir(String pMensaje){
        Intent send = new Intent(Intent.ACTION_SEND);
        send.setType("text/plain");
        send.putExtra(android.content.Intent.EXTRA_TEXT, pMensaje);
        Intent.createChooser(send, "Share with");
        vActividad.startActivity(send);
    }
    public Intent CompartirReturn(String pMensaje){
        Intent send = new Intent(Intent.ACTION_SEND);
        send.setType("text/plain");
        send.putExtra(android.content.Intent.EXTRA_TEXT, pMensaje);
        Intent.createChooser(send, "Share with");
        return send;
    }
    public Intent CompartirWAppReturn(String pMensaje){
        Intent send = new Intent(Intent.ACTION_SEND);
        send.setPackage("com.whatsapp");
        send.setType("text/plain");
        send.putExtra(android.content.Intent.EXTRA_TEXT, pMensaje);
        Intent.createChooser(send, "Share with");
        return send;
    }
    public Intent enviarFicheroTelegramReturn(String pMensaje, File pFichero){
        Uri path = FileProvider.getUriForFile(vActividad, BuildConfig.APPLICATION_ID, pFichero);
        final String appName = "org.telegram.messenger";
        Intent myIntent = new Intent(Intent.ACTION_SEND);
        myIntent.setType("text/plain");
        myIntent.setPackage(appName);
        myIntent.putExtra(android.content.Intent.EXTRA_TEXT, pMensaje);
        //myIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Pdf");
        //myIntent.putExtra(Intent.EXTRA_TEXT, vTextoEnviar);
        myIntent.putExtra(Intent.EXTRA_STREAM, path);
        Intent.createChooser(myIntent, "Share with");

        return myIntent;
    }
}
