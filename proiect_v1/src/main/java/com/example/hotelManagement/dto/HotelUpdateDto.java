package com.example.hotelManagement.dto;

import jakarta.validation.constraints.NotNull;

public class HotelUpdateDto {
    @NotNull(message = "nume de hotel nu poate fi null")
    private String nume;

    public HotelUpdateDto() {
    }

    public HotelUpdateDto(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
