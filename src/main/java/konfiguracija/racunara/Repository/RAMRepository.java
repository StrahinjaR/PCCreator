package konfiguracija.racunara.Repository;

import konfiguracija.racunara.Entity.RAM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RAMRepository extends JpaRepository<RAM,Integer> {
}
