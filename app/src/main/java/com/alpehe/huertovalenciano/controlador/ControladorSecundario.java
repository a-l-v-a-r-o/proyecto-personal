package com.alpehe.huertovalenciano.controlador;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Gravity;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class ControladorSecundario {

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
}
