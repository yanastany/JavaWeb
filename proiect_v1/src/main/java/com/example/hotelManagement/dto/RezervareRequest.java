package com.example.hotelManagement.dto;

import com.example.hotelManagement.model.Camera;
import com.example.hotelManagement.model.Clientul;


public class RezervareRequest {
    private long id;
    private int numarRezervare;

    private String dataStart;

    private String dataFinal;

    private String rezervare;

    private Camera camera;

    private Clientul clientul;

    public RezervareRequest(long id, int numarRezervare, String dataStart, String dataFinal, String rezervare, Camera camera, Clientul clientul) {
        this.id = id;
        this.numarRezervare = numarRezervare;
        this.dataStart = dataStart;
        this.dataFinal = dataFinal;
        this.rezervare = rezervare;
        this.camera = camera;
        this.clientul = clientul;
    }

    public RezervareRequest() {
    }

    public int getNumarRezervare() {
        return numarRezervare;
    }

    public void setNumarRezervare(int numarRezervare) {
        this.numarRezervare = numarRezervare;
    }

    public RezervareRequest(int numarRezervare, String dataStart, String dataFinal, String rezervare, Camera camera, Clientul clientul) {
        this.numarRezervare = numarRezervare;
        this.dataStart = dataStart;
        this.dataFinal = dataFinal;
        this.rezervare = rezervare;
        this.camera = camera;
        this.clientul = clientul;
    }

    public RezervareRequest(long id, String dataStart, String dataFinal, String rezervare, Camera camera, Clientul clientul) {
        this.id = id;
        this.dataStart = dataStart;
        this.dataFinal = dataFinal;
        this.rezervare = rezervare;
        this.camera = camera;
        this.clientul = clientul;
    }

    public RezervareRequest(String dataStart, String dataFinal, String rezervare, Camera camera, Clientul clientul) {
        this.dataStart = dataStart;
        this.dataFinal = dataFinal;
        this.rezervare = rezervare;
        this.camera = camera;
        this.clientul = clientul;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDataStart() {
        return dataStart;
    }

    public void setDataStart(String dataStart) {
        this.dataStart = dataStart;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getRezervare() {
        return rezervare;
    }

    public void setRezervare(String rezervare) {
        this.rezervare = rezervare;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Clientul getClientul() {
        return clientul;
    }

    public void setClientul(Clientul clientul) {
        this.clientul = clientul;
    }
}
