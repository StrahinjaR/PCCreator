package konfiguracija.racunara.Controller;

import konfiguracija.racunara.Entity.RAM;
import konfiguracija.racunara.Service.RAMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class RamController {

    @Autowired
    private RAMService ramService;

    @GetMapping("/rams")
    public String getrams(Model model){
        List<RAM> rams=ramService.getRAM();
        model.addAttribute("rams", rams);
        return "rams";
    }
}
