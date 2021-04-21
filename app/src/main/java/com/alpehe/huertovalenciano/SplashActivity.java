package com.alpehe.huertovalenciano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

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

        comenzar = (Button) findViewById(R.id.btnComenzar);
        circulo = (ProgressBar) findViewById(R.id.progressBar);

        //Cuando pulsas el boton comenzar más de 2 veces ya no aparece más, para agilizar.
        prefs = getPreferences(this.MODE_PRIVATE);
        editor = prefs.edit();
        totalCount = prefs.getInt("contadorInicio", 0);
        if(totalCount == 0) {
            comenzar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comenzar.setVisibility(View.INVISIBLE);
                    circulo.setVisibility(View.VISIBLE);

                    //Contar el número de veces que se pulsa el boton
                    totalCount++;
                    editor.putInt("contadorInicio", totalCount);
                    editor.commit();
                    //Para que espere 1 segundo
                    Handler handler = new Handler() {
                    };handler.postDelayed(new Runnable() {public void run() { IntentPrincipal(); }}, 1000);
                }
            });
        }else{
            comenzar.setVisibility(View.INVISIBLE);
            circulo.setVisibility(View.VISIBLE);
            //Para que espere 1 segundo
            Handler handler = new Handler() {};handler.postDelayed(new Runnable() {public void run() { IntentPrincipal(); }}, 1500);
        }
    }

    public void IntentPrincipal(){
        principal = new Intent(SplashActivity.this, PrincipalActivity.class);
        startActivity(principal);
    }
}