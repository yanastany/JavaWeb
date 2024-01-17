package com.example.hotelManagement.repositories;

import com.example.hotelManagement.model.Angajati;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AngajatiRepository extends JpaRepository<Angajati,Long> {
    List<Angajati> findAllByOrderByNumeAsc();

    List<Angajati> findAllByOrderByNumeDesc();

    //    Optional<Angajati> findByNrid(long id);
    @Query("SELECT h FROM Angajati h WHERE h.id = :id")
    Optional<Angajati> findByNrid(@Param("id") long id);

}