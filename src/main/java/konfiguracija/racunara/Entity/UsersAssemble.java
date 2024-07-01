package konfiguracija.racunara.Entity;

import jakarta.persistence.*;

@Table(name = "Users_Assemble")
@Entity
public class UsersAssemble {
@Id
    private Long assemble_id;
    private String username;
    public UsersAssemble(){};

    public UsersAssemble(Long assemble_id, String username) {
        this.assemble_id = assemble_id;
        this.username = username;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assemble_id", insertable = false, updatable = false) // Adjust this according to your database schema
    private Assemble assemble;

    public Long getAssemble_id() {
        return assemble_id;
    }

    public void setAssemble_id(Long assemble_id) {
        this.assemble_id = assemble_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
