package konfiguracija.racunara.Repository;

import konfiguracija.racunara.Entity.Psu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PsuRepository extends JpaRepository<Psu,Integer> {
}
