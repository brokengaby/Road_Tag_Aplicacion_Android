package com.example.roadtag;
import android.media.Image;

import com.google.android.gms.maps.model.LatLng;
public class Bahia {

    //Atributos
    private int id;
    private String ubicacion;
    private LatLng latLng;
    private String estado;
    private boolean reservado;
    private Image img;

    //Constructores
    public Bahia(int id, String ubicacion, LatLng latLng, String estado, boolean reservado, Image img) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.latLng = latLng;
        this.estado = estado;
        this.reservado = reservado;
        this.img = img;
    }

    public Bahia(int id, String ubicacion, LatLng latLng, String estado, boolean reservado) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.latLng = latLng;
        this.estado = estado;
        this.reservado = reservado;
    }

    //Getters/setters
    public int getId() {
        return id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
