package com.example.hotelManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Clientul {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nume;
    private String prenume;
    private String mail;
    private String telefon;


    @ManyToOne
    @JoinColumn(name = "tara")
    private Tara tara;

    public Tara getTara() {
        return tara;
    }

    public void setTara(Tara tara) {
        this.tara = tara;
    }

    public Clientul(String nume, String prenume, String mail, String telefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.mail = mail;
        this.telefon = telefon;
    }

    public Clientul() {

    }

    public Clientul(String nume, String prenume, String mail, String telefon, Tara tara) {
        this.nume = nume;
        this.prenume = prenume;
        this.mail = mail;
        this.telefon = telefon;
        this.tara = tara;
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




}
