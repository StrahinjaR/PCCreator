package konfiguracija.racunara.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CPU")
public class CPU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ranking;
    private String name;
    private String socket;
    private int price;
    private int wattage;
    private int core_count;

    private int core_clock;
    private String integrated_gpu;


    public CPU()
    {}
    public CPU(int ranking, String name, String socket, int core_count, int core_clock, int price, String integrated_gpu, int wattage) {
        this.ranking = ranking;
        this.name = name;
        this.socket = socket;
        this.core_count = core_count;
        this.core_clock = core_clock;
        this.price = price;
        this.integrated_gpu = integrated_gpu;
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

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getCore_count() {
        return core_count;
    }

    public void setCore_count(int core_count) {
        this.core_count = core_count;
    }

    public int getCore_clock() {
        return core_clock;
    }

    public void setCore_clock(int core_clock) {
        this.core_clock = core_clock;
    }

    public String getIntegrated_gpu() {
        return integrated_gpu;
    }

    public void setIntegrated_gpu(String integrated_gpu) {
        this.integrated_gpu = integrated_gpu;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }
}
