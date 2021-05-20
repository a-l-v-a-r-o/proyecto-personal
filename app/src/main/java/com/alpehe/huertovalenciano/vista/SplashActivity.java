package com.alpehe.huertovalenciano.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.alpehe.huertovalenciano.R;

public class SplashActivity extends AppCompatActivity {

    ProgressBar circulo;
    Button comenzar;
    Intent principal;

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private int totalCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        comenzar = findViewById(R.id.btnComenzar);
        circulo = findViewById(R.id.progressBar);

        //Cuando pulsas el boton comenzar más de 2 veces ya no aparece más, para agilizar.
        prefs = getPreferences(MODE_PRIVATE);
        editor = prefs.edit();
        totalCount = prefs.getInt("contadorInicio", 0);
        if(totalCount == 0) {
            comenzar.setOnClickListener(v -> {
                comenzar.setVisibility(View.INVISIBLE);
                circulo.setVisibility(View.VISIBLE);

                //Contar el número de veces que se pulsa el boton
                totalCount++;
                editor.putInt("contadorInicio", totalCount);
                editor.apply();
                //Para que espere 1 segundo
                new Handler(Looper.getMainLooper()).postDelayed(this::IntentPrincipal, 1000);
            });
        }else{
            comenzar.setVisibility(View.INVISIBLE);
            circulo.setVisibility(View.VISIBLE);
            //Para que espere 1 segundo
            new Handler(Looper.getMainLooper()).postDelayed(this::IntentPrincipal, 1500);
        }
    }

    public void IntentPrincipal(){
        principal = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(principal);
    }
}