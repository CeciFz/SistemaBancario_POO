package com.cecifz.sistemabancario_poo.controller;

import com.cecifz.sistemabancario_poo.dto.AccountTypeDto;
import com.cecifz.sistemabancario_poo.model.AccountType;
import com.cecifz.sistemabancario_poo.service.IAccountTypeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accountTypes")
@RequiredArgsConstructor
public class AccountTypeController {

    private final IAccountTypeService typeService;
    private final ModelMapper mapper;

    @PostMapping("/save")
    private ResponseEntity<AccountTypeDto> save(@RequestBody AccountType type) throws Exception {
        AccountTypeDto savedAccountType = mapper.map(typeService.save(type), AccountTypeDto.class);
        return new ResponseEntity<>(savedAccountType, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    private ResponseEntity<AccountTypeDto> update(@RequestBody AccountType type) throws Exception {
        AccountTypeDto updatedAccountType =
                mapper.map(typeService.update(type, type.getTypeId()), AccountTypeDto.class);
        return new ResponseEntity<>(updatedAccountType, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<AccountTypeDto>> readAll() throws Exception {
        List<AccountTypeDto> types  = typeService.readAll()
                .stream().map(t -> mapper.map(t, AccountTypeDto.class))
                .toList();
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountTypeDto> readById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(mapper.map(typeService.readById(id), AccountTypeDto.class),
                 HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        typeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
