package com.cecifz.sistemabancario_poo.controller;

import com.cecifz.sistemabancario_poo.model.MovementType;
import com.cecifz.sistemabancario_poo.service.IMovementTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movementTypes")
@RequiredArgsConstructor
public class MovementTypeController {
    
    private final IMovementTypeService movementTypeService;

    @PostMapping("/save")
    private ResponseEntity<MovementType> save(@RequestBody MovementType movementType) throws Exception {
        MovementType savedMovementType = movementTypeService.save(movementType);
        return new ResponseEntity<>(savedMovementType, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    private ResponseEntity<MovementType> update(@RequestBody MovementType movementType) throws Exception {
        MovementType updatedMovementType = movementTypeService.update(movementType, movementType.getIdMovementType());
        return new ResponseEntity<>(updatedMovementType, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<MovementType>> readAll() throws Exception {
        List<MovementType> cities  = movementTypeService.readAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovementType> readById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(movementTypeService.readById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

