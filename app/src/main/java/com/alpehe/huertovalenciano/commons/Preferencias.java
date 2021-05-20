package com.alpehe.huertovalenciano.commons;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferencias {
    private static String PREF_NAME = "Memoria";

    public static boolean setPreferenciasInteger(Context pContext, String pNombre, int pGuardar ) {
        SharedPreferences.Editor editor = pContext.getSharedPreferences(PREF_NAME, 0).edit();
        editor.putInt(pNombre , pGuardar);
        return editor.commit();
    }

    public static int getPreferenciasInteger(Context context, String pNombre) {
        SharedPreferences savedSession = context.getSharedPreferences(
                PREF_NAME, 0);
        return savedSession.getInt(pNombre , 0);
    }
}

