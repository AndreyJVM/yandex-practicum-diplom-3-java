package api.models;

public class Credentials {
    private String email;
    private String password;

    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static Credentials from(User user) {
        return new Credentials(user.getEmail(), user.getPassword());
    }

    public static Credentials from(String email, String password) {
        return new Credentials(email, password);
    }

    @Override
    public String toString() {
        return "email: " + email + ", password: " + password;
    }
}