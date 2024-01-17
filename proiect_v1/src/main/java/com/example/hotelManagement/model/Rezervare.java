package com.example.hotelManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Entity
public class Rezervare {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int numarRezervare;
    private String dataStart;


    private String dataFinal;


    private String rezervare;



    @OneToOne
    @JoinColumn(name = "camera")
    private Camera camera;

    @ManyToOne
    @JoinColumn(name = "clientul")
    private Clientul clientul;

    public Rezervare(long id, int numarRezervare, String dataStart, String dataFinal, String rezervare, Camera camera, Clientul clientul) {
        this.id = id;
        this.numarRezervare = numarRezervare;
        this.dataStart = dataStart;
        this.dataFinal = dataFinal;
        this.rezervare = rezervare;
        this.camera = camera;
        this.clientul = clientul;
    }

    public int getNumarRezervare() {
        return numarRezervare;
    }

    public void setNumarRezervare(int numarRezervare) {
        this.numarRezervare = numarRezervare;
    }

    public Rezervare(int numarRezervare, String dataStart, String dataFinal, String rezervare, Camera camera, Clientul clientul) {
        this.numarRezervare = numarRezervare;
        this.dataStart = dataStart;
        this.dataFinal = dataFinal;
        this.rezervare = rezervare;
        this.camera = camera;
        this.clientul = clientul;
    }


    public Rezervare(long id, String dataStart, String dataFinal, String rezervare, Camera camera, Clientul clientul) {
        this.id = id;
        this.dataStart = dataStart;
        this.dataFinal = dataFinal;
        this.rezervare = rezervare;

        this.camera = camera;

        this.clientul = clientul;
    }

    public Rezervare() {

    }

    public Rezervare(long id, String dataStart, String dataFinal, String rezervare, Camera camera) {
        this.id = id;
        this.dataStart = dataStart;
        this.dataFinal = dataFinal;
        this.rezervare = rezervare;
        this.camera = camera;

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
