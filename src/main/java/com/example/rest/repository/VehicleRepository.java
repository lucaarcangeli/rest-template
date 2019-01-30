package com.example.rest.repository;

import com.example.rest.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author OITECH develop team - 24/01/2019
 */
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {}