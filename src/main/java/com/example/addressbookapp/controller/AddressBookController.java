package com.example.addressbookapp.controller;

import com.example.addressbookapp.model.AddressBook;
import com.example.addressbookapp.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class AddressBookController {
    @Autowired
    Repository repository;

    //For adding data in the database
    @PostMapping("/add-data")
    public AddressBook addData(@RequestBody AddressBook addressBook) {
        repository.save(addressBook);
        return addressBook;
    }

    //Method to get address book by id
    @GetMapping("/getById/{Id}")
    public Optional<AddressBook> getById(@PathVariable int Id) {
        return repository.findById(Id);

    }

    //Method to get all the data
    @GetMapping("/get-all")
    public List<AddressBook> getData() {
        return repository.findAll();

    }

    @PutMapping("/update/{Id}")
    public AddressBook updateData(@RequestBody AddressBook addressBook, @PathVariable int Id) {
        Optional<AddressBook> optional = repository.findById(Id);
        if (optional.isPresent()) {
            AddressBook updatedAddressBook = new AddressBook(Id, addressBook);
            repository.save(updatedAddressBook);
            return updatedAddressBook;
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete-id")
    public List<AddressBook> deleteById(@RequestParam int ID) {
        if (repository.existsById(ID)) {
            repository.deleteById(ID);
            return repository.findAll();
        } else {
            return null;
        }
    }

    //Delete all the data
    @DeleteMapping("/delete-all")
    public List<AddressBook> deleteall() {
        if (repository.findAll().isEmpty()) {
            return null;
        } else repository.deleteAll();
        return repository.findAll();
    }
}
