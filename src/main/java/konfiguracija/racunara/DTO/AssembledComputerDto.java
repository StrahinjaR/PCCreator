package konfiguracija.racunara.DTO;

import java.util.Arrays;
import java.util.List;

public class AssembledComputerDto {
    private Long assembleId;
    private String computerName;
    private String cpuName;
    private String gpuName;
    private String motherboardName;
    private String psuName;
    private String caseName;
    private String coolerName;
    private List<String> storageNames;
    private List<String> ramNames;

    private int totalprice;

    public AssembledComputerDto(Long assembleId, int totalprice, String computerName, String cpuName, String gpuName,
                                String motherboardName, String psuName, String caseName, String coolerName,
                                String storageNames, String ramNames) {
        this.assembleId = assembleId;
        this.totalprice=totalprice;
        this.computerName = computerName;
        this.cpuName = cpuName;
        this.gpuName = gpuName;
        this.motherboardName = motherboardName;
        this.psuName = psuName;
        this.caseName = caseName;
        this.coolerName = coolerName;
        this.storageNames = Arrays.asList(storageNames.split(","));
        this.ramNames = Arrays.asList(ramNames.split(","));

    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public Long getAssembleId() {
        return assembleId;
    }

    public void setAssembleId(Long assembleId) {
        this.assembleId = assembleId;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public String getGpuName() {
        return gpuName;
    }

    public void setGpuName(String gpuName) {
        this.gpuName = gpuName;
    }

    public String getMotherboardName() {
        return motherboardName;
    }

    public void setMotherboardName(String motherboardName) {
        this.motherboardName = motherboardName;
    }

    public String getPsuName() {
        return psuName;
    }

    public void setPsuName(String psuName) {
        this.psuName = psuName;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getCoolerName() {
        return coolerName;
    }

    public void setCoolerName(String coolerName) {
        this.coolerName = coolerName;
    }

    public List<String> getStorageNames() {
        return storageNames;
    }

    public void setStorageNames(List<String> storageNames) {
        this.storageNames = storageNames;
    }

    public List<String> getRamNames() {
        return ramNames;
    }

    public void setRamNames(List<String> ramNames) {
        this.ramNames = ramNames;
    }
}
