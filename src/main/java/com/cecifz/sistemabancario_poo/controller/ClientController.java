package com.cecifz.sistemabancario_poo.controller;

import com.cecifz.sistemabancario_poo.model.Client;
import com.cecifz.sistemabancario_poo.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {
    
    private final IClientService clientService;

    @PostMapping("/save")
    private ResponseEntity<Client> save(@RequestBody Client city) throws Exception {
        Client savedClient = clientService.save(city);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    private ResponseEntity<Client> update(@RequestBody Client city) throws Exception {
        Client updatedClient = clientService.update(city, city.getDni());
        return new ResponseEntity<>(updatedClient, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Client>> readAll() throws Exception {
        List<Client> cities  = clientService.readAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Client> readById(@PathVariable String dni) throws Exception {
        return new ResponseEntity<>(clientService.readById(dni), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
