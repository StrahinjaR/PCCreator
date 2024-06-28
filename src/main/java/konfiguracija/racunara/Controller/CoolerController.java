package konfiguracija.racunara.Controller;

import konfiguracija.racunara.Entity.CCase;
import konfiguracija.racunara.Entity.Cooler;
import konfiguracija.racunara.Service.CCaseService;
import konfiguracija.racunara.Service.CoolerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class CoolerController {

    @Autowired
    private CoolerService coolerService;

    @GetMapping("/coolers")
    public String listCoolers(Model model) {
        List<Cooler> coolers = coolerService.getCoolers();
        model.addAttribute("coolers", coolers);
        return "coolers";
    }
}
