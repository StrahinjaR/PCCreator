package konfiguracija.racunara.Service;

import jakarta.transaction.Transactional;
import konfiguracija.racunara.Entity.RAM;
import konfiguracija.racunara.Entity.Storage;
import konfiguracija.racunara.Repository.RAMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RAMService {
    @Autowired
    private RAMRepository ramRepository;

    public List<RAM> getRAM(){
        return ramRepository.findAll();
    }

    @Transactional
    public RAM saveStorage(RAM ram) {
        return ramRepository.save(ram);}
    @Transactional
    public RAM findById(int id) {
        return ramRepository.findById(id).orElse(null);
    }
}
