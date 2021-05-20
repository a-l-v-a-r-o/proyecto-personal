package com.alpehe.huertovalenciano.commons;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Gravity;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ControladorMetodosGenerales {

    public static void ToastCorto(Context pContext, String pMensaje){
        Toast toast = Toast.makeText(pContext,pMensaje, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0,0);
        toast.show();
    }

    public static void ToastLargo(Context pContext, String pMensaje){
        Toast toast = Toast.makeText(pContext,pMensaje, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0,500);
        toast.show();
    }

    public byte[] filetoByteArray(String path) {
        byte[] data = null;
        try {
            System.out.println("path-> "+path);
            if(path.contains(".pdf")){
                InputStream input = new FileInputStream(path);
                int byteReads;
                ByteArrayOutputStream output = new ByteArrayOutputStream(1024);
                while ((byteReads = input.read()) != -1) {
                    output.write(byteReads);
                }
                data = output.toByteArray();
                output.close();
                input.close();
            }else {
                Bitmap imagen = (Bitmap) BitmapFactory.decodeFile(path);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                imagen.compress(Bitmap.CompressFormat.JPEG, 30, stream);
                data = stream.toByteArray();
            }
        } catch (Exception e) {
            System.out.println("filetoByteArray-> "+e);
            e.getMessage();
            return null;
        }
        return data;
    }

    //EN EL MANIFEST <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    /*public boolean compruebaConexionInternet(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info == null || !info.isConnected() || !info.isAvailable()) {
            return false;
        }
        return true;
    }*/

    public String sysdate (){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String strDate = sdf.format(c.getTime());
        return strDate;
    }

    public String anyoEnCurso (){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String strDate = sdf.format(c.getTime());
        return strDate;
    }

    public String sysdateFecha (){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = sdf.format(c.getTime());
        return strDate;
    }

    public String sysdateHours (){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String strDate = sdf.format(c.getTime());
        return strDate;
    }
}
