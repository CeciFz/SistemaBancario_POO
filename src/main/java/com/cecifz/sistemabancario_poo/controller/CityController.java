package com.cecifz.sistemabancario_poo.controller;

import com.cecifz.sistemabancario_poo.model.City;
import com.cecifz.sistemabancario_poo.service.ICityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {

    private final ICityService cityService;

    @PostMapping("/save")
    private ResponseEntity<City> save(@RequestBody City city) throws Exception {
        City savedCity = cityService.save(city);
        return new ResponseEntity<>(savedCity, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    private ResponseEntity<City> update(@RequestBody City city) throws Exception {
        City updatedCity = cityService.update(city, city.getIdCity());
        return new ResponseEntity<>(updatedCity, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<City>> readAll() throws Exception {
        List<City> cities  = cityService.readAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> readById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(cityService.readById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        cityService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
