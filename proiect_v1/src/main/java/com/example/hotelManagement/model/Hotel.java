package com.example.hotelManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Hotel {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nume;

    private String adresa;




    public Hotel(){
    }

    public Hotel(long id, String numeHotel, String adresa) {
        this.id = id;
        this.nume = numeHotel;
        this.adresa = adresa;
    }

    public Hotel(String nume, String adresa) {
        this.nume = nume;
        this.adresa = adresa;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }




}


