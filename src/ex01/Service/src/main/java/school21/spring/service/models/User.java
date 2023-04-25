package school21.spring.service.models;

public class User {
    private Long Identifier;
    private String Email;

    public User() {
        Identifier = 0L;
        Email = "email";
    }

    public User(Long identifier, String email) {
        Identifier = identifier;
        Email = email;
    }

    public Long getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(Long identifier) {
        Identifier = identifier;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
