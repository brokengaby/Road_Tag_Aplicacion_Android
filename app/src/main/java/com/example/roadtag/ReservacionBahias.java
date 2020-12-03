package com.example.roadtag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ReservacionBahias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservacion_bahias);

        //Ocultando barra de herramientas
        this.getSupportActionBar().hide();
    }
}