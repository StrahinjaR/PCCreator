package konfiguracija.racunara.Entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class RAM {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int speed;

    private int price;

    private String module;

    private int cas;
    @OneToMany(mappedBy = "ram", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AssembleRam> assembles = new HashSet<>();

    public Set<AssembleRam> getAssembles() {
        return assembles;
    }

    public void setAssembles(Set<AssembleRam> assembles) {
        this.assembles = assembles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public int getCas() {
        return cas;
    }

    public void setCas(int cas) {
        this.cas = cas;
    }
}
