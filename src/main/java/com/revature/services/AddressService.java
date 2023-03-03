package com.revature.services;

import com.revature.models.Address;
import com.revature.models.User;
import com.revature.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Optional<Address> findById(int id) {
        return addressRepository.findById(id);
    }

    public List<Optional<Address>> findByStreetName(String streetName) {
        return addressRepository.findByStreetName(streetName);
    }

    public Address save(Address a) {
        return addressRepository.save(a);
    }
}
