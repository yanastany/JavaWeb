package com.example.hotelManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Tara {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String numeTara;
    private String regiuneTara;


    public Tara(String numeTara, String regiuneTara) {
        this.numeTara = numeTara;
        this.regiuneTara = regiuneTara;
    }

    public Tara() {

    }

    public Tara(long id, String numeTara, String regiuneTara) {
        this.id = id;
        this.numeTara = numeTara;
        this.regiuneTara = regiuneTara;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeTara() {
        return numeTara;
    }

    public void setNumeTara(String numeTara) {
        this.numeTara = numeTara;
    }

    public String getRegiuneTara() {
        return regiuneTara;
    }

    public void setRegiuneTara(String regiuneTara) {
        this.regiuneTara = regiuneTara;
    }


}
