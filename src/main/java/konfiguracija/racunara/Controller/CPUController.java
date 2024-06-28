package konfiguracija.racunara.Controller;

import konfiguracija.racunara.Entity.CPU;
import konfiguracija.racunara.Entity.GPU;
import konfiguracija.racunara.Service.CPUService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CPUController {
    @Autowired
    private CPUService cpuService;

    @GetMapping("/cpus")
    public String listCPUs(Model model) {
        List<CPU> cpus = cpuService.getAllCPUs();
        model.addAttribute("cpus", cpus);
        return "cpus";
    }


}
