package com.example.hotelManagement.exception;

public class RezervareCamera extends RuntimeException{
    public RezervareCamera() {
        super("Deja exista o rezervare cu acest numar de inregistrare.");
    }
}
