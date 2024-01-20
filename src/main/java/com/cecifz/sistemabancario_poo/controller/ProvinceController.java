package com.cecifz.sistemabancario_poo.controller;

import com.cecifz.sistemabancario_poo.model.Province;
import com.cecifz.sistemabancario_poo.service.IProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provinces")
@RequiredArgsConstructor
public class ProvinceController {

    private final IProvinceService provinceService;

    @PostMapping("/save")
    private ResponseEntity<Province> save(@RequestBody Province province) throws Exception {
        Province savedProvince = provinceService.save(province);
        return new ResponseEntity<>(savedProvince, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    private ResponseEntity<Province> update(@RequestBody Province province) throws Exception {
        Province updatedProvince = provinceService.update(province, province.getProvinceId());
        return new ResponseEntity<>(updatedProvince, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Province>> readAll() throws Exception {
        List<Province> provinces  = provinceService.readAll();
        return new ResponseEntity<>(provinces, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Province> readById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(provinceService.readById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        provinceService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
