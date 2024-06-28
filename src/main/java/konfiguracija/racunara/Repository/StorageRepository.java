package konfiguracija.racunara.Repository;


import konfiguracija.racunara.Entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends JpaRepository<Storage,Integer> {
}
