package com.cecifz.sistemabancario_poo.controller;


import com.cecifz.sistemabancario_poo.dto.UserDto;
import com.cecifz.sistemabancario_poo.model.User;
import com.cecifz.sistemabancario_poo.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    
    private final IUserService userService;
    private final ModelMapper mapper;

    @PostMapping("/save")
    private ResponseEntity<UserDto> save(@RequestBody User user) throws Exception {
        UserDto savedUser = mapper.map(userService.save(user), UserDto.class);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    /*   TODO: Quitar esto - Regla de negocio: un admin podrá cambiar la contraseña, pero nunca el usuario
    @PostMapping("/update")
    private ResponseEntity<User> update(@RequestBody User user) throws Exception {
        User updatedUser = userService.update(user, user.getIdUser());
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }*/

    @GetMapping("getAll")
    public ResponseEntity<List<UserDto>> readAll() throws Exception {
        List<UserDto> userList  = userService.readAll()
                .stream().map( u -> mapper.map(u, UserDto.class))
                .toList();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> readById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(mapper.map(userService.readById(id), UserDto.class),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
