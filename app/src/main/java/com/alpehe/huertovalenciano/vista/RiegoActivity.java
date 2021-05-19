package com.alpehe.huertovalenciano.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.ToggleButton;

import com.alpehe.huertovalenciano.R;
import com.alpehe.huertovalenciano.controlador.ControladorMetodosGenerales;

public class RiegoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riego);

        ToggleButton btnTipoRiego = findViewById(R.id.btnTipoRiego);
        btnTipoRiego.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
               /*ControladorSecundario.ToastCorto(this, "Por goteo elegido");*/
            }
            else{
                /*ControladorSecundario.ToastCorto(this, "A mano elegido");*/
            }
        });

        CheckBox btnAmbos = findViewById(R.id.btnAmbos);
        btnAmbos.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                btnTipoRiego.setEnabled(false);
            }else{
                btnTipoRiego.setEnabled(true);
            }
        });

        Spinner spnDias = findViewById(R.id.spnDias);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Dias, android.R.layout.simple_spinner_item);
        spnDias.setAdapter(adapter);
        spnDias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            int cont = 0; @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Para que no entre al switch cuand se inicia la vista y se crea el spinner
                if(cont > 0) {
                    switch (position) {
                        case 0: /*ControladorSecundario.ToastCorto(RiegoActivity.this, "-");*/
                            break;
                        case 1:
                            ControladorMetodosGenerales.ToastCorto(RiegoActivity.this, "Lunes");
                            break;
                        case 2:
                            ControladorMetodosGenerales.ToastCorto(RiegoActivity.this, "Martes");
                            break;
                        case 3:
                            ControladorMetodosGenerales.ToastCorto(RiegoActivity.this, "Miercoles");
                            break;
                        case 4:
                            ControladorMetodosGenerales.ToastCorto(RiegoActivity.this, "Jueves");
                            break;
                        case 5:
                            ControladorMetodosGenerales.ToastCorto(RiegoActivity.this, "Viernes");
                            break;
                        case 6:
                            ControladorMetodosGenerales.ToastCorto(RiegoActivity.this, "Sabado");
                            break;
                        case 7:
                            ControladorMetodosGenerales.ToastCorto(RiegoActivity.this, "Domingo");
                            break;
                    }
                }else{
                    cont++;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }});

        CheckBox btnNotificar = findViewById(R.id.btnNotificar);
        btnNotificar.setChecked(true);
        btnNotificar.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                btnNotificar.setText("Notificarme");
                ControladorMetodosGenerales.ToastCorto(RiegoActivity.this, "Notificarme");
            }else{
                btnNotificar.setText("No notificarme");
                ControladorMetodosGenerales.ToastCorto(RiegoActivity.this, "No notificarme");
            }
        });
    }
}