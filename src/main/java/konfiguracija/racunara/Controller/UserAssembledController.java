package konfiguracija.racunara.Controller;

import konfiguracija.racunara.DTO.AssembledComputerDto;
import konfiguracija.racunara.Entity.Assemble;
import konfiguracija.racunara.Service.AssembleService;
import konfiguracija.racunara.Service.UsersAssembleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserAssembledController {

    @Autowired
    private AssembleService assembleService;

    @Autowired
    private UsersAssembleService usersAssembleService;
    public String getLoggedInUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            return authentication.getName();
        }
        return null;
    }
    @GetMapping("assembled")
    public String getAssembledForUser(Model model){
        List<AssembledComputerDto> assembles = assembleService.getAssembledComputersByUsername(getLoggedInUserDetails());
        model.addAttribute("assembles", assembles);
        return "user_assembles";

    }
    @GetMapping("RecommendedBuild")
    public String getAssembledForId(Model model){
        List<AssembledComputerDto> assembles = assembleService.getAssembledComputersById();
        model.addAttribute("assembles", assembles);
        return "recommendedpcs";
    }
    @PostMapping("RecommendedBuild/Add")
    public String InsertBuildToUser(Model model,@RequestParam Long assembleId)
    {
        try {
            usersAssembleService.PCsForUser(getLoggedInUserDetails(), assembleId);
            return "redirect:/assembled";
        }
        catch(Exception e)
        {return "redirect:/assembled";}
    }
    @PostMapping("user/assembled/delete")
    public String DeletePCForUser(Model model,@RequestParam Long assembleId)
    {
        usersAssembleService.DeletePCForUser(assembleId,getLoggedInUserDetails());
        return "redirect:/assembled";
    }


}
