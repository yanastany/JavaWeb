package com.example.hotelManagement.exception;

public class DuplicateCamera extends RuntimeException{
    public DuplicateCamera() {
        super("Deja exista o camera cu acest numar de inregistrare.");
    }
}
