package konfiguracija.racunara.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GPU")
public class GPU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ranking;
    private String name;
    private String memory;
    private int boostClock;
    private int price;
    private String memoryType;
    private int wattage;

    public GPU()
    {}
    public GPU(int ranking, String name, String memory, int boostClock, int price, String memoryType, int wattage) {
        this.ranking = ranking;
        this.name = name;
        this.memory = memory;
        this.boostClock = boostClock;
        this.price = price;
        this.memoryType = memoryType;
        this.wattage = wattage;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public int getBoostClock() {
        return boostClock;
    }

    public void setBoostClock(int boostClock) {
        this.boostClock = boostClock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }
}
