package konfiguracija.racunara.Service;

import jakarta.transaction.Transactional;
import konfiguracija.racunara.Entity.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StorageService {
        @Autowired
        private konfiguracija.racunara.Repository.StorageRepository storageRepository;

        public List<Storage> getAllStorage() {
            return storageRepository.findAll();
        }


      @Transactional
        public Storage saveStorage(Storage storage) {
        return storageRepository.save(storage);}
    @Transactional
    public Storage findById(int id) {
        return storageRepository.findById(id).orElse(null);
    }
}
