package konfiguracija.racunara.Service;

import konfiguracija.racunara.Entity.CCase;
import konfiguracija.racunara.Repository.CCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CCaseService {
    @Autowired
    private CCaseRepository cCaseRepository;

    public List<CCase> getCases() {return cCaseRepository.findAll();}
}
