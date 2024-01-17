package com.example.hotelManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
@Entity
public class Angajati {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nume;
    private String prenume;
    private long salariu;

    @ManyToOne
    @JoinColumn(name = "hotel")
    private Hotel hotel;

    public Angajati(String nume, String prenume, long salariu, Hotel hotel) {
        this.nume = nume;
        this.prenume = prenume;
        this.salariu = salariu;
        this.hotel = hotel;
    }

    public Angajati() {

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

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public long getSalariu() {
        return salariu;
    }

    public void setSalariu(long salariu) {
        this.salariu = salariu;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
