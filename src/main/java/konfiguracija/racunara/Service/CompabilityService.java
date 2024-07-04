package konfiguracija.racunara.Service;

import konfiguracija.racunara.Entity.*;
import konfiguracija.racunara.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

@Service
public class CompabilityService {

    @Autowired
    private CPURepository cpuRepository;
    @Autowired
    private MotherboardRepository motherboardRepository;
    @Autowired
    private GPURepository gpuRepository;
    @Autowired
    private PsuRepository psuRepository;
    @Autowired
    private RAMRepository ramRepository;

    public Boolean isSocketCompatible(int cpuId, int motherboardId){
        CPU Cpu= cpuRepository.findById(cpuId).orElse(null);
        Motherboard motherboard=motherboardRepository.findById(motherboardId).orElse(null);
        if(Cpu.getSocket().equals(motherboard.getSocket()))
            return true;
        else return false;
    }
    public Boolean isWattageEnough(int cpuId, int gpuId, int motherboardId, int psuId) {
        CPU Cpu = cpuRepository.findById(cpuId).orElse(null);
        Motherboard motherboard = motherboardRepository.findById(motherboardId).orElse(null);
        GPU gpu = gpuRepository.findById(gpuId).orElse(null);
        Psu psu = psuRepository.findById(psuId).orElse(null);
        if (Cpu.getWattage() + motherboard.getWattage() + gpu.getWattage() + 150 > psu.getWattage())
            return true;
        else return false;
    }
    public Boolean isCpuBottleneck(int cpuId, int gpuId)
    {
        return gpuId + 50 < cpuId;
    }
    public Boolean isGpuBottleneck(int cpuId, int gpuId)
    {
        return cpuId + 30 < gpuId;
    }
    private String extractDdrType(String ramDescription) {
        String[] parts = ramDescription.split(" ");
        return parts[parts.length - 1];
    }
    public Boolean isRamMBCompatible(Long ramId,int motherboardId)
    {
        RAM ram= ramRepository.findById(Math.toIntExact(ramId)).orElse(null);
        Motherboard motherboard= motherboardRepository.findById(motherboardId).orElse(null);
        System.out.println(extractDdrType(ram.getModule()));
        if(motherboard.getDdrType().equals(extractDdrType(ram.getModule())))
            return true;
        else return false;
    }
    public Boolean isRamSame(List<Long> ramIds) {
        if (ramIds.size() > 1) {
            for (int i = 1; i < ramIds.size(); i++) {
                if (ramIds.get(0) != ramIds.get(i))
                    return true;

            }
        }
        return false;
    }
    }



