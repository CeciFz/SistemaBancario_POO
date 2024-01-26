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
    private ResponseEntity<ClientDto> save(@RequestBody Client client) throws Exception {
        ClientDto savedClient = mapper.map(clientService.save(client), ClientDto.class);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    private ResponseEntity<ClientDto> update(@RequestBody Client client) throws Exception {
        ClientDto updatedClient = mapper.map(clientService.update(client, client.getClientId()), ClientDto.class);
        return new ResponseEntity<>(updatedClient, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<ClientDto>> readAll() throws Exception {
        List<ClientDto> clientList  = clientService.readAll()
                .stream().map( e -> mapper.map(e, ClientDto.class)).toList();
        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<ClientDto> readById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(mapper.map(clientService.readById(id), ClientDto.class), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{dni}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
