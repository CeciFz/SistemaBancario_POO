package com.cecifz.sistemabancario_poo.controller;

import com.cecifz.sistemabancario_poo.model.AccountType;
import com.cecifz.sistemabancario_poo.service.IAccountTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accountTypes")
@RequiredArgsConstructor
public class AccountTypeController {

    private final IAccountTypeService accountTypeService;

    @PostMapping("/save")
    private ResponseEntity<AccountType> save(@RequestBody AccountType accountType) throws Exception {
        AccountType savedAccountType = accountTypeService.save(accountType);
        return new ResponseEntity<>(savedAccountType, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    private ResponseEntity<AccountType> update(@RequestBody AccountType accountType) throws Exception {
        AccountType updatedAccountType = accountTypeService.update(accountType, accountType.getAccountTypeId());
        return new ResponseEntity<>(updatedAccountType, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<AccountType>> readAll() throws Exception {
        List<AccountType> accountTypes  = accountTypeService.readAll();
        return new ResponseEntity<>(accountTypes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountType> readById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(accountTypeService.readById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        accountTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
