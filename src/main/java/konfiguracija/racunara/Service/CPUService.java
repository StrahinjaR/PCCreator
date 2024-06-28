package konfiguracija.racunara.Service;

import konfiguracija.racunara.Entity.CPU;

import konfiguracija.racunara.Repository.CPURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CPUService {
    @Autowired
   private CPURepository cpuRepository;

    public List<CPU> getAllCPUs() {
        return cpuRepository.findAll();
    }

    public CPU getCPUById(int id) {
        Optional<CPU> optionalCPU = cpuRepository.findById(id);
        return optionalCPU.orElse(null);
    }

}
