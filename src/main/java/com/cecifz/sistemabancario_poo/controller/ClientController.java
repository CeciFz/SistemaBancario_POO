package com.cecifz.sistemabancario_poo.controller;

import com.cecifz.sistemabancario_poo.dto.ClientDto;
import com.cecifz.sistemabancario_poo.model.Client;
import com.cecifz.sistemabancario_poo.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {
    
    private final IClientService clientService;
    private final ModelMapper mapper;

    @PostMapping("/save")
    private ResponseEntity<ClientDto> save(@RequestBody Client city) throws Exception {
        ClientDto savedClient = mapper.map(clientService.save(city), ClientDto.class);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    private ResponseEntity<ClientDto> update(@RequestBody Client city) throws Exception {
        ClientDto updatedClient = mapper.map(clientService.update(city, city.getDni()), ClientDto.class);
        return new ResponseEntity<>(updatedClient, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<ClientDto>> readAll() throws Exception {
        List<ClientDto> cities  = clientService.readAll()
                .stream().map( e -> mapper.map(e, ClientDto.class)).toList();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<ClientDto> readById(@PathVariable String dni) throws Exception {
        return new ResponseEntity<>(mapper.map(clientService.readById(dni), ClientDto.class), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{dni}")
    public ResponseEntity<Void> delete(@PathVariable String dni) throws Exception {
        clientService.delete(dni);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
