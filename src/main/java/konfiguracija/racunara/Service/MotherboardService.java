package konfiguracija.racunara.Service;

import konfiguracija.racunara.Entity.Motherboard;
import konfiguracija.racunara.Repository.MotherboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotherboardService {
    @Autowired
    private MotherboardRepository motherboardRepository;
    public List<Motherboard> getMotherboards(){
        return motherboardRepository.findAll();
    }
}
