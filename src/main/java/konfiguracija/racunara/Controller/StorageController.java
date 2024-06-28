package konfiguracija.racunara.Controller;

import konfiguracija.racunara.Entity.GPU;
import konfiguracija.racunara.Entity.Storage;
import konfiguracija.racunara.Service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class StorageController {

    @Autowired
    private StorageService storageService;

    @GetMapping("/storage")
    public String listStorage(Model model){
        List<Storage> storages = storageService.getAllStorage();
        model.addAttribute("storages", storages);
        return "storage";


    }
}
