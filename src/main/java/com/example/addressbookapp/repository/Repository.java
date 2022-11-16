package com.example.addressbookapp.repository;

import com.example.addressbookapp.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository


public interface Repository extends JpaRepository<AddressBook,Integer> {

}
