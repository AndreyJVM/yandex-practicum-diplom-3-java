package api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class User {

    private String email;
    private String name;
    private String password;

    @Override
    public String toString() {
        return "email: " + email + ", password: " + password + ", name: " + name;
    }
}