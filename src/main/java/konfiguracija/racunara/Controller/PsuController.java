package konfiguracija.racunara.Controller;

import konfiguracija.racunara.Entity.Psu;
import konfiguracija.racunara.Service.PsuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class PsuController {

    @Autowired
    private PsuService psuService;

    @GetMapping("/psus")
    public String listPsus(Model model) {
        List<Psu> psus = psuService.getPsus();
        model.addAttribute("psus", psus);
        return "psus";
    }
}
