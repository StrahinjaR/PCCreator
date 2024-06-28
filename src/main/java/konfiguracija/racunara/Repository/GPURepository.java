package konfiguracija.racunara.Repository;

import konfiguracija.racunara.Entity.GPU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GPURepository extends JpaRepository<GPU, Integer> {

}
