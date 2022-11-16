package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBook;
import com.example.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AddressBookService implements IService {
    @Autowired
    AddressBookRepository addressBookRepository;


    //Overriding the interface method of IService to perform logic to add the data
    @Override
    public AddressBook addData(AddressBookDTO addressBookDTO) {
        AddressBook addedAddressBook = new AddressBook(addressBookDTO);
        addressBookRepository.save(addedAddressBook);
        return addedAddressBook;
    }

    @Override
    //Overriding the interface method of IService to perform logic to get address book by id

    public Optional<AddressBook> getById(int Id) {
        Optional<AddressBook> optional = addressBookRepository.findById(Id);
        if (optional.isPresent()) {
            Optional<AddressBook> foundData = addressBookRepository.findById(Id);
            return foundData;
        } else return null;
    }

    @Override
    //Overriding the interface method of IService to perform logic to get all the data

    public List<AddressBook> getData() {
        return addressBookRepository.findAll();

    }

    //Overriding the interface method of IService to perform logic to update the data
    @Override
    public AddressBook updateData(int Id, AddressBookDTO addressBookDTO) {
        Optional<AddressBook> optional = addressBookRepository.findById(Id);
        if (optional.isPresent()) {
            AddressBook updatedAddressBook = new AddressBook(Id, addressBookDTO);
            addressBookRepository.save(updatedAddressBook);
            return updatedAddressBook;
        } else {
            return null;
        }
    }

    //Overriding the interface method of IService to perform logic to delete by id
    @Override
    public List<AddressBook> deleteById(int ID) {
        if (addressBookRepository.existsById(ID)) {
            addressBookRepository.deleteById(ID);
            return addressBookRepository.findAll();
        } else {
            return null;
        }
    }

    //Overriding the interface method of IService to perform logic to delete all the data
    @Override
    public List<AddressBook> deleteall() {
        if (addressBookRepository.findAll().isEmpty()) {
            return null;
        } else addressBookRepository.deleteAll();
        return addressBookRepository.findAll();
    }
}