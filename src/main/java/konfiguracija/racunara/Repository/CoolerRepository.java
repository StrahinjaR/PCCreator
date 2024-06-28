package konfiguracija.racunara.Repository;

import konfiguracija.racunara.Entity.Cooler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoolerRepository extends JpaRepository<Cooler,Integer> {
}
