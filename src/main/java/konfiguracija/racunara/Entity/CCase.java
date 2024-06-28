package konfiguracija.racunara.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "C_CASE")
public class CCase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String type;

    private int price;

    private double weight;
    public CCase(){}

    public CCase(int id, String name, String type, int price, double weight) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
