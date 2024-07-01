package konfiguracija.racunara.Service;

import konfiguracija.racunara.DTO.AssembledComputerDto;
import konfiguracija.racunara.Entity.Assemble;
import konfiguracija.racunara.Repository.AssembleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssembleService {
    @Autowired
    private AssembleRepository repository;
    @Transactional
    public void saveAssemble(Assemble assemble) {
        repository.save(assemble);
    }

    public List<AssembledComputerDto> getAssembledComputersByUsername(String username) {
        List<Object[]> results = repository.findAssembledComputersByUsername(username);

        return results.stream().map(result -> new AssembledComputerDto(
                ((Number) result[0]).longValue(),
                (String) result[1],
                (String) result[2],
                (String) result[3],
                (String) result[4],
                (String) result[5],
                (String) result[6],
                (String) result[7],
                (String) result[8],
                (String) result[9]
        )).collect(Collectors.toList());
}}
