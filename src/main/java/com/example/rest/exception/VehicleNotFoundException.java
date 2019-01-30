package com.example.rest.exception;

import lombok.NoArgsConstructor;


/**
 * @author OITECH develop team - 24/01/2019
 */
@NoArgsConstructor
public class VehicleNotFoundException extends RuntimeException {

    public VehicleNotFoundException(Long vehicleId) {
        super("Vehicle: " + vehicleId + " not found.");
    }
}
