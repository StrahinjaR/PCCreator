package konfiguracija.racunara.Service;

import konfiguracija.racunara.Entity.UsersAssemble;
import konfiguracija.racunara.Repository.UsersAssembleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersAssembleService {

    @Autowired
    private UsersAssembleRepository usersAssembleRepository;

    @Transactional
    public void PCsForUser(String username, Long assemble_id){
        usersAssembleRepository.AssembledForUser(username,assemble_id);
    }
    @Transactional
    public void DeletePCForUser(Long assembleId,String username)
    {
        usersAssembleRepository.DeleteAssembledForUser(assembleId,username);
    }
}
