package konfiguracija.racunara.Entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Assemble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String computerName;

    private int cpuId;

    private int gpuId;

    private int motherboardId;

    private int psuId;
    private int caseId;
    private int coolerId;
    private int totalPrice;

    @OneToMany(mappedBy = "assemble", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AssembleStorage> storages = new HashSet<>();

    @OneToMany(mappedBy = "assemble", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AssembleRam> rams = new HashSet<>();

    // Many-to-One mappings


    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public int getCpuId() {
        return cpuId;
    }

    public void setCpuId(int cpuId) {
        this.cpuId = cpuId;
    }

    public int getGpuId() {
        return gpuId;
    }

    public void setGpuId(int gpuId) {
        this.gpuId = gpuId;
    }

    public int getMotherboardId() {
        return motherboardId;
    }

    public void setMotherboardId(int motherboardId) {
        this.motherboardId = motherboardId;
    }

    public int getPsuId() {
        return psuId;
    }

    public void setPsuId(int psuId) {
        this.psuId = psuId;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public int getCoolerId() {
        return coolerId;
    }

    public void setCoolerId(int coolerId) {
        this.coolerId = coolerId;
    }

    public Set<AssembleStorage> getStorages() {
        return storages;
    }

    public void setStorages(Set<AssembleStorage> storages) {
        this.storages = storages;
    }

    public Set<AssembleRam> getRams() {
        return rams;
    }

    public void setRams(Set<AssembleRam> rams) {
        this.rams = rams;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void addStorage(Storage storage) {
        AssembleStorage assembleStorage = new AssembleStorage(this, storage);
        storages.add(assembleStorage);
    }
    public void addRam(RAM ram)
    {
        AssembleRam assembleRam= new AssembleRam(this, ram);
        rams.add(assembleRam);
    }
}
