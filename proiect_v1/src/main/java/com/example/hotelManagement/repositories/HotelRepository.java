package com.example.hotelManagement.repositories;

import com.example.hotelManagement.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {
    List<Hotel> findAllByOrderByNumeAsc();

    List<Hotel> findAllByOrderByNumeDesc();

//    Optional<Hotel> findByNrid(long id);
@Query("SELECT h FROM Hotel h WHERE h.id = :id")
Optional<Hotel> findByNrid(@Param("id") long id);

}
