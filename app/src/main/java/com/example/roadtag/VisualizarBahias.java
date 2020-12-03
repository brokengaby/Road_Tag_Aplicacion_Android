package com.example.roadtag;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class VisualizarBahias extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    //Objetos de prueba
    private Marker markerGdl;

    ArrayList<Bahia> bahias = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_bahias);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Añadiendo objetos a ARRAYLIST, posterior se leeran de bdd
        bahias.add(new Bahia(1, "Guadalajara", new LatLng(20.66654225, -103.37045789), "LIBRE",false));
        bahias.add(new Bahia(2, "Guadalajara", new LatLng(20.66622102, -103.37036133), "LIBRE",false));
        bahias.add(new Bahia(3, "Guadalajara", new LatLng(20.66702409, -103.37053855), "LIBRE",false));
        bahias.add(new Bahia(4, "Guadalajara", new LatLng(20.66764647, -103.37008774), "DESCARGANDO",false));
        bahias.add(new Bahia(5, "Guadalajara", new LatLng(20.66754107, -103.3688432), "RESERVADO",true));
    }

    //Devuelve el icono apropiado para el estado de la bahía
    private int obtenerIconoApropiad(String estado){
        if(estado.equals("LIBRE")){
            return R.drawable.poste_verde;
        }
        if(estado.equals("DESCARGANDO")){
            return R.drawable.poste_azul;
        }
        if(estado.equals("RESERVADO")){
            return R.drawable.poste_rojo;
        }
        if(estado.equals("PROCESANDO")){
            return R.drawable.poste_amarillo;
        }
        return 0;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng guadalajara = new LatLng(20.6720375, -103.3383962);
        markerGdl = googleMap.addMarker(new MarkerOptions()
                .position(guadalajara)
                .title("Guadalajara centro")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icono_ciudad)));

        //Añadiendo los puntos de las bahías
        int i = 1;
        for (Bahia b:bahias){
            mMap.addMarker(new MarkerOptions()
                    .position(b.getLatLng())
                    .title("Bahía "+i)
                    .icon(BitmapDescriptorFactory.fromResource(obtenerIconoApropiad(b.getEstado()))));
            i++;
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bahias.get(3).getLatLng(), 17));
    }
}