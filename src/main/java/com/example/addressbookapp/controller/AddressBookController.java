package com.example.addressbookapp.controller;

import com.example.addressbookapp.model.AddressBook;
import com.example.addressbookapp.service.IService;
import dto.AddressBookDTO;
import dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController

public class AddressBookController {
    @Autowired
    IService iService;

    //For adding data in the database
    @PostMapping("/add-data")
    public ResponseEntity<ResponseDTO> addData(@RequestBody AddressBook addressBook) {
        AddressBook addressBookDTO = iService.addData(addressBook);
        ResponseDTO responseDTO = new ResponseDTO("Data Added in Repo", addressBookDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    //Method to get address book by its id
    @GetMapping("/getById/{Id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable int Id) {
        Optional<AddressBook> addressBookDTO = iService.getById(Id);
        ResponseDTO responseDTO = new ResponseDTO("Get call Id successfully", addressBookDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);
    }

    //Method to get all the data
    @GetMapping("/get-all")
    public List<AddressBook> getData() {
        return iService.getData();
    }

    //Method to update the data in the database
    @PutMapping("/update/{Id}")
    public ResponseEntity<ResponseDTO> updateData(@RequestBody AddressBookDTO addressBookDTO, @PathVariable int Id) {
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

    //Delete all the data
    @DeleteMapping("/delete-all")
    public ResponseEntity<ResponseDTO> deleteall() {
        List<AddressBook> addressBook = iService.deleteall();
        ResponseDTO responseDTO = new ResponseDTO("All data deleted in the Repo", addressBook);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}