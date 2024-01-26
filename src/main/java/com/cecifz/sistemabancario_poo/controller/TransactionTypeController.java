package com.cecifz.sistemabancario_poo.controller;

import com.cecifz.sistemabancario_poo.dto.TransactionTypeDto;
import com.cecifz.sistemabancario_poo.model.TransactionType;
import com.cecifz.sistemabancario_poo.service.ITransactionTypeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transactionTypes")
@RequiredArgsConstructor
public class TransactionTypeController {
    
    private final ITransactionTypeService typeService;
    private final ModelMapper mapper;

    @PostMapping("/save")
    private ResponseEntity<TransactionTypeDto> save(@RequestBody TransactionType type) throws Exception {
        TransactionTypeDto savedType = mapper.map(typeService.save(type), TransactionTypeDto.class);
        return new ResponseEntity<>(savedType, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    private ResponseEntity<TransactionTypeDto> update(@RequestBody TransactionType type) throws Exception {
        TransactionTypeDto updatedType =
                mapper.map(typeService.update(type, type.getTypeId()), TransactionTypeDto.class);
        return new ResponseEntity<>(updatedType, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<TransactionTypeDto>> readAll() throws Exception {
        List<TransactionTypeDto> typesList  = typeService.readAll()
                .stream().map( t -> mapper.map(t, TransactionTypeDto.class))
                .toList();
        return new ResponseEntity<>(typesList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionTypeDto> readById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(mapper.map(typeService.readById(id), TransactionTypeDto.class),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        typeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

