package konfiguracija.racunara.Repository;

import konfiguracija.racunara.Entity.Assemble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssembleRepository extends JpaRepository<Assemble, Integer> {
}
