package com.globallogic.Userservice.repository;

import com.globallogic.Userservice.model.Geo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoRepository extends JpaRepository<Geo,Integer> {
}
