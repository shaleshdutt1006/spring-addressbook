package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.exception.AddressBookException;
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
        } else throw new AddressBookException("Address-book of this id is not present");
    }

    //Overriding the interface method of IService to perform logic to get address book by firstName
    @Override
    public List<AddressBook> findByFirstName(String firstName) {
        List<AddressBook> person = addressBookRepository.findAddressBookByFirstName(firstName);
        if (!person.isEmpty()) {
            return person;
        } else {
            throw new AddressBookException("No Person of this Name");
        }
    }

    @Override
    //Overriding the interface method of IService to perform logic to get all the data

    public List<AddressBook> getData() {
        if (addressBookRepository.findAll().isEmpty()) {
            throw new AddressBookException("No Address-book Present in the database");
        } else
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
            throw new AddressBookException("Address-book not present in the list to update");
        }
    }

    //Overriding the interface method of IService to perform logic to delete by id
    @Override
    public List<AddressBook> deleteById(int ID) {
        if (addressBookRepository.existsById(ID)) {
            addressBookRepository.deleteById(ID);
            return addressBookRepository.findAll();
        } else {
            throw new AddressBookException("Id is not present to delete in database");
        }
    }

    //Overriding the interface method of IService to perform logic to delete all the data
    @Override
    public List<AddressBook> deleteall() {
        if (addressBookRepository.findAll().isEmpty()) {
            throw new AddressBookException("No address-book Present to delete");
        } else addressBookRepository.deleteAll();
        return addressBookRepository.findAll();
    }
}
