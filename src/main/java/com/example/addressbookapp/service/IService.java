package com.example.addressbookapp.service;

import com.example.addressbookapp.model.AddressBook;

import java.util.List;
import java.util.Optional;

public interface IService {

    public AddressBook addData(AddressBook addressBook);

    //Method to get address book by id
    Optional<AddressBook> getById(int Id);

    //Method to get all the data
    List<AddressBook> getData();

    AddressBook updateData(AddressBook addressBook, int Id);

    List<AddressBook> deleteById(int ID);

    //Delete all the data
    List<AddressBook> deleteall();
}
