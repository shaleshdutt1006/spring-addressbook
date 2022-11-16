package com.example.addressbookapp.model;

import com.example.addressbookapp.dto.AddressBookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class AddressBook {

    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String state;
    private String city;
    private String zipCode;

    //Constructor to update the data
    public AddressBook(int id, AddressBookDTO addressBookDTO) {
        this.id = id;
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.address = addressBookDTO.getAddress();
        this.phoneNumber = addressBookDTO.getPhoneNumber();
        this.state = addressBookDTO.getState();
        this.city = addressBookDTO.getCity();
        this.zipCode = addressBookDTO.getZipCode();
    }

    //Constructor to insert the data
    public AddressBook(AddressBookDTO addressBookDTO) {
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.address = addressBookDTO.getAddress();
        this.phoneNumber = addressBookDTO.getPhoneNumber();
        this.state = addressBookDTO.getState();
        this.city = addressBookDTO.getCity();
        this.zipCode = addressBookDTO.getZipCode();
    }
}

