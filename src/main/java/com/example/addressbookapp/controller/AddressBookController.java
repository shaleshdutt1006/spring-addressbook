package com.example.addressbookapp.controller;

import com.example.addressbookapp.model.AddressBook;
import com.example.addressbookapp.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class AddressBookController {
    @Autowired
    IService iService;

    //For adding data in the database
    @PostMapping("/add-data")
    public AddressBook addData(@RequestBody AddressBook addressBook) {
        return iService.addData(addressBook);
    }

    //Method to get address book by id
    @GetMapping("/getById/{Id}")
    public Optional<AddressBook> getById(@PathVariable int Id) {
        return iService.getById(Id);

    }

    //Method to get all the data
    @GetMapping("/get-all")
    public List<AddressBook> getData() {
        return iService.getData();

    }

    @PutMapping("/update/{Id}")
    public AddressBook updateData(@RequestBody AddressBook addressBook, @PathVariable int Id) {
        return iService.updateData(addressBook, Id);
    }

    //Method to delete the data by its id
    @DeleteMapping("/delete-id")
    public List<AddressBook> deleteById(@RequestParam int ID) {
        return iService.deleteById(ID);
    }

    //Delete all the data
    @DeleteMapping("/delete-all")
    public List<AddressBook> deleteall() {
        return iService.deleteall();
    }
}