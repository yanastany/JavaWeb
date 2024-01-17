package com.example.hotelManagement.dto;

import com.example.hotelManagement.model.Hotel;
import jakarta.validation.constraints.NotBlank;

public class AngajatiRequest {
    @NotBlank(message = "Numele nu poate fi null")
    private String nume;
    private String prenume;
    private long salariu;
    private Hotel hotel;

    public AngajatiRequest(String nume, String prenume, long salariu, Hotel hotel) {
        this.nume = nume;
        this.prenume = prenume;
        this.salariu = salariu;
        this.hotel = hotel;
    }

    public AngajatiRequest() {
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public AngajatiRequest(String nume, String prenume, long salariu) {
        this.nume = nume;
        this.prenume = prenume;
        this.salariu = salariu;
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
}
