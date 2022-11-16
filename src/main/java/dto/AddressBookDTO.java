package dto;

import lombok.Data;

@Data
//Using @Data is equivalent to using @code @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
//Using various annotations like @pattern @min to put validations on the class

public class AddressBookDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private Long phoneNumber;
    private String state;
    private String city;
    private String zipCode;


}
