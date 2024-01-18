package com.cecifz.sistemabancario_poo.controller;


import com.cecifz.sistemabancario_poo.model.User;
import com.cecifz.sistemabancario_poo.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    
    private final IUserService userService;

    @PostMapping("/save")
    private ResponseEntity<User> save(@RequestBody User user) throws Exception {
        User savedUser = userService.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    private ResponseEntity<User> update(@RequestBody User user) throws Exception {
        User updatedUser = userService.update(user, user.getIdUser());
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<User>> readAll() throws Exception {
        List<User> cities  = userService.readAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> readById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(userService.readById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
