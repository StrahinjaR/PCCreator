package konfiguracija.racunara.Controller;

import konfiguracija.racunara.Entity.GPU;
import konfiguracija.racunara.Entity.Motherboard;
import konfiguracija.racunara.Service.MotherboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class MotherboardController {

    @Autowired
    private MotherboardService motherboardService;
    @GetMapping("/motherboards")
    public String listMotherboards(Model model) {
        List<Motherboard> motherboards = motherboardService.getMotherboards();
        model.addAttribute("motherboards", motherboards);
        return "motherboards";
    }
}
