package com.springtesting.web;

import com.springtesting.model.Address;
import com.springtesting.repo.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/address")
public class AddressController
{

    private AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository)
    {
        this.addressRepository=addressRepository;
    }

    @PostMapping(path = "/create")
    public void createAddress(@RequestBody Address address)
    {
        addressRepository.save(address);
    }

    @GetMapping(value = "/list")
    public List<Address> getAddresses()
    {
        return addressRepository.findAll();
    }

    @GetMapping(value = "/find/{id}")
    public Optional<Address> getAddressById(@PathVariable Long id)
    {
        return addressRepository.findById(id);
    }

}