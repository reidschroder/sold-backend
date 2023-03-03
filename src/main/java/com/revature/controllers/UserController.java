package com.revature.controllers;

import com.revature.dtos.RegisterDTO;
import com.revature.models.User;
import com.revature.repositories.AddressRepository;
import com.revature.repositories.UserRepository;
import com.revature.services.UserService;
import com.revature.services.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.beans.Customizer;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"}, allowCredentials = "true")
@RequestMapping(value="/users")
public class UserController {


    private UserService uService;
    private AddressService aService;

    public UserController(UserService uService, AddressService aService){
        this.uService = uService;
        this.aService = aService;
    }


    //Get All Users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(uService.getAll());
    }


}
