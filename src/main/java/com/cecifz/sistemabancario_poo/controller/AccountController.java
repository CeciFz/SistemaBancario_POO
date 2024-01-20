package com.cecifz.sistemabancario_poo.controller;

import com.cecifz.sistemabancario_poo.model.Account;
import com.cecifz.sistemabancario_poo.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final IAccountService accountService;

    @PostMapping("/save")
    private ResponseEntity<Account> save(@RequestBody Account account) throws Exception {
        Account savedAccount = accountService.save(account);
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }
    @PostMapping("/update")
    private ResponseEntity<Account> update(@RequestBody Account account) throws Exception {
        Account updatedAccount = accountService.update(account, account.getAccountNumber());
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Account>> readAll() throws Exception {
        List<Account> account  = accountService.readAll();
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping("/{nroCuenta}")
    public ResponseEntity<Account> readById(@PathVariable Integer accountNumber) throws Exception {
        return new ResponseEntity<>(accountService.readById(accountNumber), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{accountNumber}")
    public ResponseEntity<Void> delete(@PathVariable Integer accountNumber) throws Exception {
        accountService.delete(accountNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
