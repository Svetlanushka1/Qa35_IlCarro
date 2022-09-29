package models;

public class User {
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String phone;

    public User withName(String name) {
        this.name = name;
        return  this; //new User();
    }

    public User withLastname(String lastname) {
        this.lastname = lastname;
        return  this;
    }

    public User withEmail(String email) {
        this.email = email;
        return  this;
    }

    public User withPassword(String password) {
        this.password = password;
        return  this;
    }

    public User withPhone(String phone) {
        this.phone = phone;
        return  this;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
