package konfiguracija.racunara.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USERS")
public class Users {
    @Id
    private String username;
    private String password;
    private String role;
    private String email;
    public Users(){

    }
    public Users(String name, String password,String role,String email) {
        this.username = name;
        this.password = password;
        this.role=role;
        this.email=email;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
