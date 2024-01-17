package com.example.hotelManagement.dto;

import com.example.hotelManagement.model.Tara;
import jakarta.validation.constraints.NotBlank;

public class ClientulRequest {
    @NotBlank(message = "Numele nu poate fi null")
    private String nume;
    private String prenume;
    private String mail;
    private String telefon;
    private Tara tara;

    public ClientulRequest(String nume, String prenume, String mail, String telefon, Tara tara) {
        this.nume = nume;
        this.prenume = prenume;
        this.mail = mail;
        this.telefon = telefon;
        this.tara = tara;
    }

    public ClientulRequest() {
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Tara getTara() {
        return tara;
    }

    public void setTara(Tara tara) {
        this.tara = tara;
    }
}
