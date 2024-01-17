package com.example.hotelManagement.repositories;

import com.example.hotelManagement.model.Tara;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TaraRepository extends JpaRepository<Tara,Long> {
    List<Tara> findAllByOrderByNumeTaraAsc();

    List<Tara> findAllByOrderByNumeTaraDesc();


    @Query("SELECT h FROM Tara h WHERE h.id = :id")
    Optional<Tara> findByNrid(@Param("id") long id);

}
