package com.alpehe.huertovalenciano;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar circulo;
    Button comenzar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comenzar = (Button) findViewById(R.id.btnComenzar);
        circulo = (ProgressBar) findViewById(R.id.progressBar);

        comenzar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                comenzar.setVisibility(View.INVISIBLE);
                circulo.setVisibility(View.VISIBLE);
            }
        });
    }
}