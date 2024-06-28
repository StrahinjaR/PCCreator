package konfiguracija.racunara.Repository;

import konfiguracija.racunara.Entity.CPU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CPURepository extends JpaRepository<CPU,Integer> {
}
