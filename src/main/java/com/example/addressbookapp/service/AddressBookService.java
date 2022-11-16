package com.example.addressbookapp.service;

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


    @Override
    public AddressBook addData(AddressBook addressBook) {
        addressBookRepository.save(addressBook);
        return addressBook;
    }

    @Override
    //Method to get address book by id

    public Optional<AddressBook> getById(int Id) {
        return addressBookRepository.findById(Id);
    }

    @Override
    //Method to get all the data

    public List<AddressBook> getData() {
        return addressBookRepository.findAll();

    }

    @Override
    public AddressBook updateData(AddressBook addressBook, int Id) {
        Optional<AddressBook> optional = addressBookRepository.findById(Id);
        if (optional.isPresent()) {
            AddressBook updatedAddressBook = new AddressBook(Id, addressBook);
            addressBookRepository.save(updatedAddressBook);
            return updatedAddressBook;
        } else {
            return null;
        }
    }

    @Override
    public List<AddressBook> deleteById(int ID) {
        if (addressBookRepository.existsById(ID)) {
            addressBookRepository.deleteById(ID);
            return addressBookRepository.findAll();
        } else {
            return null;
        }
    }

    //Delete all the data
    @Override
    public List<AddressBook> deleteall() {
        if (addressBookRepository.findAll().isEmpty()) {
            return null;
        } else addressBookRepository.deleteAll();
        return addressBookRepository.findAll();
    }
}
