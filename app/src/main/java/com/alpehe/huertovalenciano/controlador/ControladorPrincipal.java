package com.alpehe.huertovalenciano.controlador;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import androidx.core.content.FileProvider;

import com.alpehe.huertovalenciano.BuildConfig;
import com.alpehe.huertovalenciano.vista.AjustesActivity;
import com.alpehe.huertovalenciano.vista.BotonesActivity;
import com.alpehe.huertovalenciano.vista.RiegoActivity;
import com.alpehe.huertovalenciano.vista.VistaPlantaActivity;

import java.io.File;

public class ControladorPrincipal {

    private Activity vActividad;

    public ControladorPrincipal(Activity pActividad){
        this.vActividad = pActividad;
    }

    /*public void lanzarListaPlantas(){
        Intent plantas = new Intent(vActividad, ListaPlantasActivity.class);
        vActividad.startActivity(plantas);
    }
    public Intent lanzarListaPlantasReturn(){
        Intent plantas = new Intent(vActividad, ListaPlantasActivity.class);
        return plantas;
    }*/

    public void lanzarVistaPlanta(){
        Intent vistaP = new Intent(vActividad, VistaPlantaActivity.class);
        vActividad.startActivity(vistaP);
    }
    public Intent lanzarVistaPlantaReturn(){
        Intent vistaP = new Intent(vActividad, VistaPlantaActivity.class);
        return vistaP;
    }

    public void lanzarRiego(){
            Intent riego = new Intent(vActividad, RiegoActivity.class);
        vActividad.startActivity(riego);
    }
    public Intent lanzarRiegoReturn(){
        Intent riego = new Intent(vActividad, RiegoActivity.class);
        return  riego;
    }

    public void lanzarBotones(){
        Intent botones = new Intent(vActividad, BotonesActivity.class);
        vActividad.startActivity(botones);
    }
    public Intent lanzarBotonesReturn(){
        Intent botones = new Intent(vActividad, BotonesActivity.class);
        return botones;
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
