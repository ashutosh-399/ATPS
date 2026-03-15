package com.toll.toll_service.repository;

import com.toll.toll_service.enity.Toll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TollRepo extends JpaRepository<Toll, Long> {

    Optional<Toll> findTollByVehicleType(String vehicleType);

}
