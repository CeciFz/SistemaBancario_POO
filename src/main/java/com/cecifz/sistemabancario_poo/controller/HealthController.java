package com.cecifz.sistemabancario_poo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HealthController {

    @GetMapping
    public ResponseEntity<Void> health()  {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
