package konfiguracija.racunara.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Motherboard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String socket;

    private int memoryMax;

    private int memorySlots;
    private String  ddrType;

    private int price;

    private int wattage;

    public Motherboard(){}

    public Motherboard(int id, String name, String socket, int memoryMax, int memorySlots,String ddrType, int price, int wattage) {
        this.id = id;
        this.name = name;
        this.socket = socket;
        this.memoryMax = memoryMax;
        this.memorySlots = memorySlots;
        this.ddrType=ddrType;
        this.price = price;
        this.wattage = wattage;
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

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getMemoryMax() {
        return memoryMax;
    }

    public void setMemoryMax(int memoryMax) {
        this.memoryMax = memoryMax;
    }

    public int getMemorySlots() {
        return memorySlots;
    }

    public void setMemorySlots(int memorySlots) {
        this.memorySlots = memorySlots;
    }

    public String getDdrType() {
        return ddrType;
    }

    public void setDdrType(String ddrType) {
        this.ddrType = ddrType;
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