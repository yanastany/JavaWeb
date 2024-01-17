package com.example.hotelManagement.dto;

import jakarta.validation.constraints.NotBlank;

public class HotelRequest {
    @NotBlank(message = "Numele nu poate fi null")
    private String nume;



    private String Adresa;

    public HotelRequest(String nume, String adresa) {
        this.nume = nume;
        Adresa = adresa;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }
}
