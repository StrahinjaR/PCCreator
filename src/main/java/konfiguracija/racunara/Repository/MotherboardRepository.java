package konfiguracija.racunara.Repository;

import konfiguracija.racunara.Entity.Motherboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotherboardRepository extends JpaRepository<Motherboard,Integer> {
}
