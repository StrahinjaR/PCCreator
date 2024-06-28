package konfiguracija.racunara.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Cooler {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String fanRpm;

    private double noiseLevel;

    private int price;

    public Cooler(){}

    public Cooler(int id, String name, String fanRpm, double noiseLevel, int price) {
        this.id = id;
        this.name = name;
        this.fanRpm = fanRpm;
        this.noiseLevel = noiseLevel;
        this.price = price;
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

    public String getFanRpm() {
        return fanRpm;
    }

    public void setFanRpm(String fanRpm) {
        this.fanRpm = fanRpm;
    }

    public double getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(double noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
