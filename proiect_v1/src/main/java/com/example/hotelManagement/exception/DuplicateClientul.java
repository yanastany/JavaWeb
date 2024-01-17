package com.example.hotelManagement.exception;

public class DuplicateClientul extends RuntimeException{
    public DuplicateClientul() {
        super("Deja exista un client cu acest numar de inregistrare.");
    }
}
