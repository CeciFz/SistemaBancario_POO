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

    private final IAccountTypeService accountTypeService;
    private final ModelMapper mapper;

    @PostMapping("/save")
    private ResponseEntity<AccountTypeDto> save(@RequestBody AccountType accountType) throws Exception {
        AccountTypeDto savedAccountType = mapper.map(accountTypeService.save(accountType), AccountTypeDto.class);
        return new ResponseEntity<>(savedAccountType, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    private ResponseEntity<AccountTypeDto> update(@RequestBody AccountType accountType) throws Exception {
        AccountTypeDto updatedAccountType = mapper.map(accountTypeService.update(accountType, accountType.getAccountTypeId()), AccountTypeDto.class);
        return new ResponseEntity<>(updatedAccountType, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<AccountTypeDto>> readAll() throws Exception {
        List<AccountTypeDto> accountTypes  = accountTypeService.readAll()
                .stream().map(t -> mapper.map(t, AccountTypeDto.class))
                .toList();
        return new ResponseEntity<>(accountTypes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountTypeDto> readById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(mapper.map(accountTypeService.readById(id), AccountTypeDto.class),
                 HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        accountTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
