package com.revature.controllers;

import com.revature.models.Address;
import com.revature.repositories.AddressRepository;
import com.revature.services.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"}, allowCredentials = "true")
@RequestMapping(value = "/address")
public class AddressController {
    private AddressService aService;

    public AddressController(AddressService aService) {
        this.aService = aService;
    }

    @GetMapping(value="/address/{id}")
    public ResponseEntity getAddressById(@PathVariable int id) {
        Optional<Address> addressOptional = aService.findById(id);
        if (addressOptional.isPresent()) {
            Address a = addressOptional.get();
            return ResponseEntity.ok(a);
        }
        return ResponseEntity.badRequest().body("Cannot find an address with that ID");
    }

    public ResponseEntity addAddress(@RequestBody Address a) {
        List<Optional<Address>> addressOptionalList = aService.findByStreetName(a.getStreetName());
        for (int i = 0; i <addressOptionalList.size(); i++) {
            if (addressOptionalList.get(i).isPresent()){
                Address current = addressOptionalList.get(i).get();
                if(current.equals(a)){
                    return ResponseEntity.accepted().body(current);
                }
            }
        }

        Address newAddress = aService.save(a);

        if (newAddress == null) {
            return ResponseEntity.status(500).body("Address couldn't be added to the database");
        }
        return ResponseEntity.accepted().body(newAddress);
    }

}
