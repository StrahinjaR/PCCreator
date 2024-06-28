package konfiguracija.racunara.Service;

import konfiguracija.racunara.Entity.GPU;
import konfiguracija.racunara.Repository.GPURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GPUService {

    @Autowired
    private GPURepository gpuRepository;

    public List<GPU> getAllGPUs() {
        return gpuRepository.findAll();
    }

    public GPU getGPUById(int id) {
        Optional<GPU> optionalGPU = gpuRepository.findById(id);
        return optionalGPU.orElse(null);
    }
}
