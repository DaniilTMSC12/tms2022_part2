package by.teachmeskills.login.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String email;
    private String password;

    {
        email = "qwerty@gmail.com";
        password = "qwerty12345";
    }


}
