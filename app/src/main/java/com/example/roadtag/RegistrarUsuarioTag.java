package com.example.roadtag;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
public class RegistrarUsuarioTag extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario_tag);

        //Ocultando barra
        this.getSupportActionBar().hide();
    }
}