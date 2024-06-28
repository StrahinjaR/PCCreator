package konfiguracija.racunara.Service;

import konfiguracija.racunara.Entity.Assemble;
import konfiguracija.racunara.Repository.AssembleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AssembleService {
    @Autowired
    private AssembleRepository repository;
    @Transactional
    public void saveAssemble(Assemble assemble) {
        repository.save(assemble);
    }


}
