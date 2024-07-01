package konfiguracija.racunara.Repository;

import jakarta.transaction.Transactional;
import konfiguracija.racunara.Entity.UsersAssemble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface UsersAssembleRepository extends JpaRepository<UsersAssemble,String> {


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Users_Assemble(username,assemble_id) VALUES(:username,:assemble_id)",nativeQuery = true)
    void AssembledForUser(@Param("username") String username,@Param("assemble_id") Long assemble_id);


}
