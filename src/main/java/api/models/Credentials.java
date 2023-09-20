package api.models;

public class Credentials {
    private String email;
    private String password;

    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "email: " + email + ", password: " + password;
    }
}