package com.cecifz.sistemabancario_poo.controller;


import com.cecifz.sistemabancario_poo.model.Role;
import com.cecifz.sistemabancario_poo.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
    
    private final IRoleService roleService;

    @PostMapping("/save")
    private ResponseEntity<Role> save(@RequestBody Role role) throws Exception {
        Role savedRole = roleService.save(role);
        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    private ResponseEntity<Role> update(@RequestBody Role role) throws Exception {
        Role updatedRole = roleService.update(role, role.getIdRole());
        return new ResponseEntity<>(updatedRole, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Role>> readAll() throws Exception {
        List<Role> cities  = roleService.readAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> readById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(roleService.readById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
