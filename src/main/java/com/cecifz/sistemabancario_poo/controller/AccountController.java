package com.cecifz.sistemabancario_poo.controller;

import com.cecifz.sistemabancario_poo.dto.AccountDto;
import com.cecifz.sistemabancario_poo.model.Account;
import com.cecifz.sistemabancario_poo.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final IAccountService accountService;
    private final ModelMapper mapper;

    @PostMapping("/save")
    private ResponseEntity<AccountDto> save(@RequestBody Account account) throws Exception {
        AccountDto savedAccount = mapper.map(accountService.save(account), AccountDto.class);
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }
    @PostMapping("/update")
    private ResponseEntity<AccountDto> update(@RequestBody Account account) throws Exception {
        AccountDto updatedAccount = mapper.map(accountService.update(account, account.getAccountNumber()), AccountDto.class);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<AccountDto>> readAll() throws Exception {
        List<AccountDto> account  = accountService.readAll()
                .stream().map( e -> mapper.map(e, AccountDto.class)).toList();
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountDto> readById(@PathVariable Integer accountNumber) throws Exception {
        return new ResponseEntity<>(mapper.map(accountService.readById(accountNumber), AccountDto.class), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{accountNumber}")
    public ResponseEntity<Void> delete(@PathVariable Integer accountNumber) throws Exception {
        accountService.delete(accountNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
