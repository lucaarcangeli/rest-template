package com.example.rest;

import com.example.rest.domain.User;
import com.example.rest.domain.Vehicle;
import com.example.rest.repository.UserRepository;
import com.example.rest.repository.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private VehicleRepository vehiclesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {
        log.debug("initializing vehiclesRepository data...");
        Arrays.asList("moto", "car").forEach(v -> this.vehiclesRepository.saveAndFlush(Vehicle.builder().name(v).build()));

        log.debug("printing all vehiclesRepository...");
        this.vehiclesRepository.findAll().forEach(v -> log.debug(" Vehicle :" + v.toString()));

        this.userRepository.save(User.builder()
                .username("user")
                .password(this.passwordEncoder.encode("password"))
                .roles(Arrays.asList("ROLE_USER"))
                .build()
        );

        this.userRepository.save(User.builder()
                .username("admin")
                .password(this.passwordEncoder.encode("password"))
                .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
                .build()
        );

        log.debug("printing all userRepository...");
        this.userRepository.findAll().forEach(v -> log.debug(" User :" + v.toString()));
    }
}
