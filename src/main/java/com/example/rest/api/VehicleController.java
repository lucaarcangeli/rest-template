package com.example.rest.api;

import com.example.rest.api.ntt.VehicleNtt;
import com.example.rest.domain.Vehicle;
import com.example.rest.exception.VehicleNotFoundException;
import com.example.rest.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;


/**
 * @author OITECH develop team - 24/01/2019
 */
@RestController
@RequestMapping("/v1/vehicles")
public class VehicleController {

    @Autowired
    private VehicleRepository vehiclesRepository;


    @PostMapping()
    public ResponseEntity save(@RequestBody VehicleNtt form, HttpServletRequest request) {

        Vehicle saved = vehiclesRepository.save(Vehicle.builder().name(form.getName()).build());

        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromContextPath(request)
                        .path("/v1/vehiclesRepository/{id}")
                        .buildAndExpand(saved.getId())
                        .toUri())
                .build();
    }


    @GetMapping()
    public ResponseEntity all() {
        return ResponseEntity.ok(vehiclesRepository.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(vehiclesRepository.findById(id).orElseThrow(() -> new VehicleNotFoundException()));
    }


    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody VehicleNtt form) {
        Vehicle existed = vehiclesRepository.findById(id).orElseThrow(() -> new VehicleNotFoundException());
        existed.setName(form.getName());
        vehiclesRepository.save(existed);
        
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Vehicle existed = vehiclesRepository.findById(id).orElseThrow(() -> new VehicleNotFoundException());
        vehiclesRepository.delete(existed);
        
        return ResponseEntity.noContent().build();
    }
}