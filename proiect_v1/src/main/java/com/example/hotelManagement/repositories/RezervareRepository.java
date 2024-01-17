package com.example.hotelManagement.repositories;

import com.example.hotelManagement.model.Rezervare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RezervareRepository extends JpaRepository<Rezervare,Long> {
    List<Rezervare> findAllByOrderByNumarRezervareAsc();

    List<Rezervare> findAllByOrderByNumarRezervareDesc();

    //    Optional<Rezervare> findByNrid(long id);
    @Query("SELECT h FROM Rezervare h WHERE h.id = :id")
    Optional<Rezervare> findByNrid(@Param("id") long id);

}
