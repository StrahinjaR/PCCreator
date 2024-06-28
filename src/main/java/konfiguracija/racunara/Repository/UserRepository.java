package konfiguracija.racunara.Repository;

import konfiguracija.racunara.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,String> {

    @Query(value = "select * from USERS where username = ?1", nativeQuery = true)
    Optional<Users> findUserByUsername(String username);
}
