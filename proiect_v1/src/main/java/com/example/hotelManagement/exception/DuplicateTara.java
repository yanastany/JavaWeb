package com.example.hotelManagement.exception;

public class DuplicateTara extends RuntimeException{
    public DuplicateTara() {
        super("Deja exista o tara cu acest numar de inregistrare.");
    }
}
