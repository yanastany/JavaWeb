package com.example.hotelManagement.exception;

public class DuplicateHotel extends RuntimeException{
    public DuplicateHotel() {
        super("Deja exista un hotel cu acest numar de inregistrare.");
    }
}
