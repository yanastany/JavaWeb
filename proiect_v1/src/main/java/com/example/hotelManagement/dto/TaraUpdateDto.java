package com.example.hotelManagement.dto;

import jakarta.validation.constraints.NotNull;

public class TaraUpdateDto {
    @NotNull(message = "nume de tara nu poate fi null")
    private String numeTara;
    private String regiuneTara;

    public TaraUpdateDto(String numeTara, String regiuneTara) {
        this.numeTara = numeTara;
        this.regiuneTara = regiuneTara;
    }

    public TaraUpdateDto() {
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
