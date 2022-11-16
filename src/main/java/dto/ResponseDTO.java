package dto;

import lombok.Data;

//Using @Data is equivalent to using @code @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
//- Generates getters for all fields, a useful toString method, hashCode and equals
//@Data

public class ResponseDTO {

public String message;
public Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
