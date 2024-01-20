package com.cecifz.sistemabancario_poo.controller;

import com.cecifz.sistemabancario_poo.model.Phone;
import com.cecifz.sistemabancario_poo.service.IPhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phones")
@RequiredArgsConstructor
public class PhoneController {
    
    private final IPhoneService phoneService;

    @PostMapping("/save")
    private ResponseEntity<Phone> save(@RequestBody Phone phone) throws Exception {
        Phone savedPhone = phoneService.save(phone);
        return new ResponseEntity<>(savedPhone, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    private ResponseEntity<Phone> update(@RequestBody Phone phone) throws Exception {
        Phone updatedPhone = phoneService.update(phone, phone.getClientPhone().getDni());
        return new ResponseEntity<>(updatedPhone, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Phone>> readAll() throws Exception {
        List<Phone> cities  = phoneService.readAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{phone}")
    public ResponseEntity<Phone> readById(@PathVariable String phone) throws Exception {
        return new ResponseEntity<>(phoneService.readById(phone), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{phone}")
    public ResponseEntity<Void> delete(@PathVariable String phone) throws Exception {
        phoneService.delete(phone);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

