package com.example.addressbookapp.exception;

//Custom Exception for EmployeePayrollApp

public class AddressBookException extends RuntimeException {

    public AddressBookException(String message) {
        //super keyword used to give message to the runtime Exception class
        super(message);
    }
}
