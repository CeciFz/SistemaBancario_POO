package com.cecifz.sistemabancario_poo.controller;

import com.cecifz.sistemabancario_poo.dto.CityDto;
import com.cecifz.sistemabancario_poo.model.City;
import com.cecifz.sistemabancario_poo.service.ICityService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {

    private final ICityService cityService;
    private final ModelMapper mapper;

    @PostMapping("/save")
    private ResponseEntity<CityDto> save(@RequestBody CityDto cityDto) throws Exception {
        City city = mapper.map(cityDto, City.class);
        CityDto savedCity = mapper.map(cityService.save(city), CityDto.class);
        return new ResponseEntity<>(savedCity, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    private ResponseEntity<CityDto> update(@RequestBody City city) throws Exception {
        CityDto updatedCity = mapper.map(cityService.update(city, city.getCityId()), CityDto.class);
        return new ResponseEntity<>(updatedCity, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<CityDto>> readAll() throws Exception {
        List<CityDto> cities  = cityService.readAll()
                .stream().map( city -> mapper.map(city, CityDto.class))
                .toList();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDto> readById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(mapper.map(cityService.readById(id), CityDto.class), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        cityService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
