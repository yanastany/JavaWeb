package com.example.hotelManagement.repositories;

import com.example.hotelManagement.model.Clientul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ClientulRepository extends JpaRepository<Clientul,Long> {
    List<Clientul> findAllByOrderByNumeAsc();

    List<Clientul> findAllByOrderByNumeDesc();

    //    Optional<Camera> findByNrid(long id);
    @Query("SELECT h FROM Clientul h WHERE h.id = :id")
    Optional<Clientul> findByNrid(@Param("id") long id);

}
