package com.simonmov.MonitoreoFlotas.controller;

import com.simonmov.MonitoreoFlotas.domain.User;
import com.simonmov.MonitoreoFlotas.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> findAll(){
       return ResponseEntity.ok(this.userService.findAll());
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Integer id){
        return this.userService.findById(id);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody  User user){
        return new ResponseEntity<>(
            this.userService.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteById(@PathVariable Integer id){
            this.userService.deleteById(id);
            return ResponseEntity.ok().build();
    }
}
