package konfiguracija.racunara.Service;

import konfiguracija.racunara.Entity.Psu;
import konfiguracija.racunara.Repository.PsuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PsuService {
    @Autowired
    private PsuRepository psuRepository;

    public List<Psu> getPsus(){return psuRepository.findAll();}
}
