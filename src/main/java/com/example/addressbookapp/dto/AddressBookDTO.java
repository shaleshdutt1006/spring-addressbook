package com.example.addressbookapp.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.*;


//Using @Data is equivalent to using @code @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
//Using various annotations like @pattern @min to put validations on the class

public @Data class AddressBookDTO {
// @NotNull: The CharSequence, Collection, Map or Array object is not null, but can be empty.
// @NotEmpty: The CharSequence, Collection, Map or Array object is not null and size > 0
// @NotEmpty(message = "First name cannot be null and must have size greater than 0",means we cannot use
//without giving something to firstname there must be something but in case of not null can use empty string.

    @NotEmpty(message = "First Name is mandatory")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Employee First Name Invalid")
    private String firstName;

    // @NotNull means Second name must not be null, empty value/space can be considered means we have Consider
    //the lastname in postman whether it is empty if we can not give input it gives error.
    @NotNull
    private String lastName;

    @Pattern(regexp = ".{10,50}", message = "Address should have limit from 10 to 50 words")
    private String address;

    @Pattern(regexp = "[0-9]{10}", message = "Mobile number should at least have ten digits")
    private String phoneNumber;

    private String state;
    private String city;

    @Pattern(regexp = "[0-9]{6}", message = "Pin code should have 6 characters")
    private String zipCode;


}