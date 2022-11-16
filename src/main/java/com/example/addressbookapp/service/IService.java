package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBook;

import java.util.List;
import java.util.Optional;

public interface IService {

    //Method to add the data
    AddressBook addData(AddressBookDTO addressBookDTO);

    //Method to get address book by its id
    Optional<AddressBook> getById(int Id);

    //Method to get all the data
    List<AddressBook> getData();

    //Method to update the data using its Id
    AddressBook updateData(int Id, AddressBookDTO addressBookDTO);

    //Method to delete the data using its Id
    List<AddressBook> deleteById(int ID);

    //Delete all the data
    List<AddressBook> deleteall();
}


