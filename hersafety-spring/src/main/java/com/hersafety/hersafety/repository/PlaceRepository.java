package com.hersafety.hersafety.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hersafety.hersafety.model.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Long>{
    //method to get place by name
    Optional<Place> findByName(String name);
    Optional<Place> findByPlaceId(String placeId);
}
