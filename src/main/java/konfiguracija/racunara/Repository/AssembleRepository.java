package konfiguracija.racunara.Repository;

import konfiguracija.racunara.DTO.AssembledComputerDto;
import konfiguracija.racunara.Entity.Assemble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssembleRepository extends JpaRepository<Assemble, Integer> {
    @Query(value = "SELECT " +
            "a.id, " +
            "a.total_price," +
            "a.computer_name AS computerName, " +
            "c.name AS cpuName, " +
            "g.name AS gpuName, " +
            "m.name AS motherboardName, " +
            "p.name AS psuName, " +
            "cc.name AS caseName, " +
            "cl.name AS coolerName, " +
            "GROUP_CONCAT(DISTINCT s.name ORDER BY s.name ASC SEPARATOR ',') AS storageNames, " +
            "GROUP_CONCAT(DISTINCT r.name ORDER BY r.name ASC SEPARATOR ',') AS ramNames " +
            "FROM users_assemble ua " +
            "JOIN assemble a ON ua.assemble_id = a.id " +
            "JOIN cpu c ON a.cpu_id = c.ranking " +
            "JOIN gpu g ON a.gpu_id = g.ranking " +
            "JOIN motherboard m ON a.motherboard_id = m.id " +
            "JOIN psu p ON a.psu_id = p.id " +
            "JOIN c_case cc ON a.case_id = cc.id " +
            "JOIN cooler cl ON a.cooler_id = cl.id " +
            "LEFT JOIN assemble_storage ast ON a.id = ast.assemble_id " +
            "LEFT JOIN storage s ON ast.storage_id = s.id " +
            "LEFT JOIN assemble_ram ar ON a.id = ar.assemble_id " +
            "LEFT JOIN ram r ON ar.ram_id = r.id " +
            "WHERE ua.username = :username " +
            "GROUP BY a.id, a.computer_name, c.name, g.name, m.name, p.name, cc.name, cl.name",
            nativeQuery = true)
    List<Object[]> findAssembledComputersByUsername(@Param("username") String username);
    @Query(value = "SELECT " +
            "a.id, " +
            "a.total_price," +
            "a.computer_name AS computerName, " +
            "c.name AS cpuName, " +
            "g.name AS gpuName, " +
            "m.name AS motherboardName, " +
            "p.name AS psuName, " +
            "cc.name AS caseName, " +
            "cl.name AS coolerName, " +
            "GROUP_CONCAT(DISTINCT s.name ORDER BY s.name ASC SEPARATOR ',') AS storageNames, " +
            "GROUP_CONCAT(DISTINCT r.name ORDER BY r.name ASC SEPARATOR ',') AS ramNames " +
            "FROM users_assemble ua " +
            "JOIN assemble a ON ua.assemble_id = a.id " +
            "JOIN cpu c ON a.cpu_id = c.ranking " +
            "JOIN gpu g ON a.gpu_id = g.ranking " +
            "JOIN motherboard m ON a.motherboard_id = m.id " +
            "JOIN psu p ON a.psu_id = p.id " +
            "JOIN c_case cc ON a.case_id = cc.id " +
            "JOIN cooler cl ON a.cooler_id = cl.id " +
            "LEFT JOIN assemble_storage ast ON a.id = ast.assemble_id " +
            "LEFT JOIN storage s ON ast.storage_id = s.id " +
            "LEFT JOIN assemble_ram ar ON a.id = ar.assemble_id " +
            "LEFT JOIN ram r ON ar.ram_id = r.id " +
            "WHERE a.id BETWEEN 7 AND 9 " +
            "GROUP BY a.id, a.computer_name, c.name, g.name, m.name, p.name, cc.name, cl.name",
            nativeQuery = true)
    List<Object[]> findAssembledComputersByUsername();


}
