package com.example.roadtag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RegistrarVehiculos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_vehiculos);

        //Ocultar barra
        this.getSupportActionBar().hide();

    }
}