package com.cecifz.sistemabancario_poo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public ResponseEntity<Void> health()  {
        return new ResponseEntity<>(HttpStatus.OK);
    }


    // TODO TOMORROW: Agregar los controller para cargar las tablas bases
    //Revisar cómo es para q al guardar te muestre la provincia entera
    // También armar los scripts de postgre y subirlos a github
    // No olvidar los DTO. Puede q ahí surgan mapper. Rever el orden de todo esto!
    //Agregar logs!



}
