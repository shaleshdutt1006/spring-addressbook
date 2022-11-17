package com.example.addressbookapp.repository;

import com.example.addressbookapp.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {

    // Find Person in the Address-book by its first name
    @Query(value = "select * from address_book where first_name= :firstName",nativeQuery = true)
    List<AddressBook> findAddressBookByFirstName(String firstName);

}
