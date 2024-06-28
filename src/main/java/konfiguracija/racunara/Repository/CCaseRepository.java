package konfiguracija.racunara.Repository;

import konfiguracija.racunara.Entity.CCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CCaseRepository extends JpaRepository<CCase,Integer> {
}
