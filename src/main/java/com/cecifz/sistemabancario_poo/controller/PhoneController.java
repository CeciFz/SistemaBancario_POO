package com.cecifz.sistemabancario_poo.controller;

import com.cecifz.sistemabancario_poo.dto.PhoneDto;
import com.cecifz.sistemabancario_poo.model.Phone;
import com.cecifz.sistemabancario_poo.service.IPhoneService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phones")
@RequiredArgsConstructor
public class PhoneController {
    
    private final IPhoneService phoneService;
    private final ModelMapper mapper;

    @PostMapping("/save")
    private ResponseEntity<PhoneDto> save(@RequestBody Phone phone) throws Exception {
        PhoneDto savedPhone = mapper.map(phoneService.save(phone), PhoneDto.class);
        return new ResponseEntity<>(savedPhone, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    private ResponseEntity<PhoneDto> update(@RequestBody Phone phone) throws Exception {
        PhoneDto updatedPhone = mapper.map(
                phoneService.update(phone, phone.getPhoneNumber()), PhoneDto.class);
        return new ResponseEntity<>(updatedPhone, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<PhoneDto>> readAll() throws Exception {
        List<PhoneDto> phoneList  = phoneService.readAll()
                .stream().map( p -> mapper.map(p, PhoneDto.class))
                .toList();
        return new ResponseEntity<>(phoneList, HttpStatus.OK);
    }

    @GetMapping("/{phone}")
    public ResponseEntity<PhoneDto> readById(@PathVariable String phone) throws Exception {
        return new ResponseEntity<>(mapper.map(phoneService.readById(phone), PhoneDto.class),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/{phone}")
    public ResponseEntity<Void> delete(@PathVariable String phone) throws Exception {
        phoneService.delete(phone);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

