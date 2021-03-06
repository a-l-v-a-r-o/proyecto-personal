package com.alpehe.huertovalenciano.vista;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import com.alpehe.huertovalenciano.R;
import com.alpehe.huertovalenciano.commons.ControladorPrincipal;
import com.google.android.material.snackbar.Snackbar;

public class AjustesActivity extends AppCompatActivity {

    Button btnAcercaDe, btnDonar, btnCompartir, btnHistorial;
    ControladorPrincipal principal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        principal = new ControladorPrincipal(this);
        iniciarVistas();
        iniciarAcciones();
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }

    public void iniciarVistas(){
        btnAcercaDe = findViewById(R.id.btnAcercaDe);
        btnCompartir = findViewById(R.id.btnCompartir);
        btnDonar = findViewById(R.id.btnDonar);
        btnHistorial = findViewById(R.id.btnHistorial);
    }

    public void iniciarAcciones(){

        btnAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                principal.lanzarAcercaDe();
            }
        });

        btnCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                principal.Compartir("Prueba la mejor apicaci??n de gesti??n de tu huerto valenciano (Link de PlayStore)");
            }
        });

        btnDonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Sin acci??n asignada", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}