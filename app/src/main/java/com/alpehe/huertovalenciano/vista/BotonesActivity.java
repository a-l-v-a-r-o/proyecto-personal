package com.alpehe.huertovalenciano.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alpehe.huertovalenciano.R;
import com.alpehe.huertovalenciano.commons.ControladorPrincipal;

public class BotonesActivity extends AppCompatActivity {

    Button btnAjustes, btnAcercaDe, btnDonar, btnCompartir;
    ControladorPrincipal principal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botones);

        principal = new ControladorPrincipal(BotonesActivity.this);

        iniciarVistas();
        iniciarAcciones();
    }

    public void iniciarVistas(){
        btnAjustes = findViewById(R.id.btnAjustes);
        btnAcercaDe = findViewById(R.id.btnAcercaDe);
        btnCompartir = findViewById(R.id.btnCompartir);
        btnDonar = findViewById(R.id.btnDonar);
    }

    public void iniciarAcciones(){
        btnAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                principal.lanzarAjustes();
            }
        });

        btnAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                principal.lanzarAcercaDe();
            }
        });

        btnCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                principal.Compartir("Prueba la mejor apicación de gestión de tu huerto valenciano (Link de PlayStore)");
            }
        });

        btnDonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}