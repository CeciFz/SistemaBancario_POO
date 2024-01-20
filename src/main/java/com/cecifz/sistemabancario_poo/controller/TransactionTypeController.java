package com.cecifz.sistemabancario_poo.controller;

import com.cecifz.sistemabancario_poo.model.TransactionType;
import com.cecifz.sistemabancario_poo.service.ITransactionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transactionTypes")
@RequiredArgsConstructor
public class TransactionTypeController {
    
    private final ITransactionTypeService transactionTypeService;

    @PostMapping("/save")
    private ResponseEntity<TransactionType> save(@RequestBody TransactionType transactionType) throws Exception {
        TransactionType savedTransactionType = transactionTypeService.save(transactionType);
        return new ResponseEntity<>(savedTransactionType, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    private ResponseEntity<TransactionType> update(@RequestBody TransactionType transactionType) throws Exception {
        TransactionType updatedTransactionType = transactionTypeService.update(transactionType, transactionType.getTransactionTypeId());
        return new ResponseEntity<>(updatedTransactionType, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<TransactionType>> readAll() throws Exception {
        List<TransactionType> cities  = transactionTypeService.readAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionType> readById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(transactionTypeService.readById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        transactionTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

