package com.cecifz.sistemabancario_poo.controller;


import com.cecifz.sistemabancario_poo.dto.RoleDto;
import com.cecifz.sistemabancario_poo.model.Role;
import com.cecifz.sistemabancario_poo.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
    
    private final IRoleService roleService;
    private final ModelMapper mapper;

    @PostMapping("/save")
    private ResponseEntity<RoleDto> save(@RequestBody Role role) throws Exception {
        RoleDto savedRole = mapper.map(roleService.save(role), RoleDto.class);
        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    private ResponseEntity<RoleDto> update(@RequestBody Role role) throws Exception {
        RoleDto updatedRole = mapper.map(roleService.update(role, role.getRoleId()), RoleDto.class);
        return new ResponseEntity<>(updatedRole, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<RoleDto>> readAll() throws Exception {
        List<RoleDto> roleList  = roleService.readAll()
                .stream().map( r -> mapper.map(r, RoleDto.class))
                .toList();
        return new ResponseEntity<>(roleList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> readById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(mapper.map(roleService.readById(id), RoleDto.class), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        roleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
