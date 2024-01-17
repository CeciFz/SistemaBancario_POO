package com.cecifz.sistemabancario_poo.controller;

import com.cecifz.sistemabancario_poo.model.Account;
import com.cecifz.sistemabancario_poo.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final IAccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> readAll() throws Exception {
        List<Account> accountList = accountService.readAll();
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

}
