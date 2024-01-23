package com.cecifz.sistemabancario_poo.controller;

import com.cecifz.sistemabancario_poo.dto.ProvinceDto;
import com.cecifz.sistemabancario_poo.model.Province;
import com.cecifz.sistemabancario_poo.service.IProvinceService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provinces")
@RequiredArgsConstructor
public class ProvinceController {

    private final IProvinceService provinceService;
    private final ModelMapper mapper;

    @PostMapping("/save")
    private ResponseEntity<ProvinceDto> save(@RequestBody Province province) throws Exception {
        ProvinceDto savedProvince = mapper.map(provinceService.save(province), ProvinceDto.class);
        return new ResponseEntity<>(savedProvince, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    private ResponseEntity<ProvinceDto> update(@RequestBody Province province) throws Exception {
        ProvinceDto updatedProvince = mapper.map(
                provinceService.update(province, province.getProvinceId()),
                ProvinceDto.class);
        return new ResponseEntity<>(updatedProvince, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<ProvinceDto>> readAll() throws Exception {
        List<ProvinceDto> provinces  = provinceService.readAll()
                .stream().map( p -> mapper.map(p, ProvinceDto.class))
                .toList();
        return new ResponseEntity<>(provinces, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProvinceDto> readById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(
                mapper.map(provinceService.readById(id), ProvinceDto.class),
                        HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        provinceService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
