package com.pokeshop.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/healthcheck")
public class HealthCheckController {

    @RequestMapping("/status")
    public ResponseEntity<String> version() {
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }

}