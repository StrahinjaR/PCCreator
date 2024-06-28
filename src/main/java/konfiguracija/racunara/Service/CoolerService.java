package konfiguracija.racunara.Service;

import konfiguracija.racunara.Entity.Cooler;
import konfiguracija.racunara.Repository.CoolerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoolerService {
    @Autowired
    private CoolerRepository coolerRepository;

    public List<Cooler> getCoolers(){
        return coolerRepository.findAll();
    }
}
