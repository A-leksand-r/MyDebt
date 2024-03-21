package pet.project.mydebt.dtos;

import lombok.Data;

@Data
public class UserRegistrationDto {

    private String lastName;

    private String firstName;

    private String middleName;

    private String username;

    private String password;

    private String email;

    private String phone;

}
