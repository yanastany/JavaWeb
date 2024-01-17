package com.example.hotelManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
@Entity
public class Camera {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long numar;


    @ManyToOne
    @JoinColumn(name = "hotel")
    private Hotel hotel;




    public Camera(){

    }

    public Camera(long id, long numar, Hotel hotel) {
        this.id = id;
        this.numar = numar;

        this.hotel = hotel;

    }

    public Camera(long numar,  Hotel hotel) {
        this.numar = numar;

        this.hotel = hotel;
    }



    public Camera(long numar) {
        this.numar = numar;

    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumarCamera() {
        return numar;
    }

    public void setNumarCamera(long numar) {
        this.numar = numar;
    }





    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }


}
