package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.dto.ResponseDTO;
import com.example.addressbookapp.model.AddressBook;
import com.example.addressbookapp.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController

public class AddressBookController {
    @Autowired
    IService iService;
    //@Valid is always use in method to apply validation

    //Method for adding data in the database
    @PostMapping("/add-data")
    public ResponseEntity<ResponseDTO> addData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook addedAddressBook = iService.addData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data Added in Repository", addedAddressBook);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    //Method to get address book by its id
    @GetMapping("/getById/{Id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable int Id) {
        Optional<AddressBook> addressBookDTO = iService.getById(Id);
        ResponseDTO responseDTO = new ResponseDTO("Get call Id successfully", addressBookDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
    }

    //Method to find person by its firstName by custom query in repository
    @GetMapping("/getByFirstName")
    public ResponseEntity<ResponseDTO> getByFirstName(@RequestParam String firstName) {
        List<AddressBook> person = iService.findByFirstName(firstName);
        ResponseDTO responseDTO = new ResponseDTO("Persons who have this first name are", person);
        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
    }

    //Method to find person of same city by custom query in repository
    @GetMapping("/getBySameCity")
    public ResponseEntity<ResponseDTO> getBySameCity(@RequestParam String city) {
        List<AddressBook> person = iService.findByCity(city);
        ResponseDTO responseDTO = new ResponseDTO("Persons of the same city are", person);
        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
    }
    //Method to sort person by their Zipcode using custom query in repository
    @GetMapping("/orderByZipcode")
    public ResponseEntity<ResponseDTO> orderByZipcode() {
        List<AddressBook> person = iService.orderByZipcode();
        ResponseDTO responseDTO = new ResponseDTO("Persons ordered according to zipcodes", person);
        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
    }

    //Method to get all the data of the address-books
    @GetMapping("/get-all")
    public List<AddressBook> getData() {
        return iService.getData();
    }

    //Method to update the data in the database
    @PutMapping("/update/{Id}")
    public ResponseEntity<ResponseDTO> updateData(@Valid @RequestBody AddressBookDTO addressBookDTO, @PathVariable int Id) {
        AddressBook updatedAddressBook = iService.updateData(Id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data Updated Successfully in Repo", updatedAddressBook);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    //Method to delete the data by its id
    @DeleteMapping("/delete-id")
    public ResponseEntity<ResponseDTO> deleteById(@RequestParam int ID) {
        List<AddressBook> addressBook = iService.deleteById(ID);
        ResponseDTO responseDTO = new ResponseDTO("Data deleted Successfully in Repo", addressBook);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //Method to delete all the data
    @DeleteMapping("/delete-all")
    public ResponseEntity<ResponseDTO> deleteall() {
        List<AddressBook> addressBook = iService.deleteall();
        ResponseDTO responseDTO = new ResponseDTO("All data deleted in the Repo", addressBook);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}