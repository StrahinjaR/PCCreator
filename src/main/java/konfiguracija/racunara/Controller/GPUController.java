package konfiguracija.racunara.Controller;

import konfiguracija.racunara.Entity.GPU;
import konfiguracija.racunara.Service.GPUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GPUController {

    @Autowired
    private GPUService gpuService;

    @GetMapping("/gpus")
    public String listGPUs(Model model) {
        List<GPU> gpus = gpuService.getAllGPUs();
        model.addAttribute("gpus", gpus);
        return "gpus";
    }


}
