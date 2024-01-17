package com.example.hotelManagement.exception;

public class DuplicateAngajati extends RuntimeException{
    public DuplicateAngajati() {
        super("Deja exista in angajat cu acest numar de inregistrare.");
    }
}
