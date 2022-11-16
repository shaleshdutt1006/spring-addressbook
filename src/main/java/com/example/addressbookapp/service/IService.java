package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBook;

import java.util.List;
import java.util.Optional;

public interface IService {
    //the interface method of IService to perform logic to add the data
    AddressBook addData(AddressBookDTO addressBookDTO);

    //the interface method of IService to perform logic to get address book by id
    Optional<AddressBook> getById(int Id);

    //the interface method of IService to perform logic to get all the data
    List<AddressBook> getData();

    //the interface method of IService to perform logic to update the data
    AddressBook updateData(int Id, AddressBookDTO addressBookDTO);

    //the interface method of IService to perform logic to delete by id
    List<AddressBook> deleteById(int ID);

    //the interface method of IService to perform logic to delete all the data
    List<AddressBook> deleteall();
}
