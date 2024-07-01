package konfiguracija.racunara.Controller;

import konfiguracija.racunara.DTO.AssembledComputerDto;
import konfiguracija.racunara.Entity.Assemble;
import konfiguracija.racunara.Service.AssembleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserAssembledController {

    @Autowired
    private AssembleService assembleService;
    public String getLoggedInUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            return authentication.getName();
        }
        return null;
    }
    @GetMapping("user/assembled")
    public String getAssembledForUser(Model model){
        List<AssembledComputerDto> assembles = assembleService.getAssembledComputersByUsername(getLoggedInUserDetails());
        model.addAttribute("assembles", assembles);
        return "user_assembles";

    }

}
