package com.example.hotelManagement.dto;

import com.example.hotelManagement.model.Hotel;
import jakarta.validation.constraints.NotNull;

public class CameraRequest {
    @NotNull(message = "Numele nu poate fi null")
    private long numar;



    private Hotel hotel;

    public CameraRequest(long numar, Hotel hotel) {
        this.numar = numar;
        this.hotel = hotel;
    }

    public long getNumar() {
        return numar;
    }

    public void setNumar(long numar) {
        this.numar = numar;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
