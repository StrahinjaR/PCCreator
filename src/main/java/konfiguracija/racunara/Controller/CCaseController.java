package konfiguracija.racunara.Controller;

import konfiguracija.racunara.Entity.CCase;
import konfiguracija.racunara.Service.CCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CCaseController {
    @Autowired
    private CCaseService cCaseService;

    @GetMapping("/cases")
    public String listCases(Model model) {
        List<CCase> cases = cCaseService.getCases();
        model.addAttribute("cases", cases);
        return "cases";
    }
}
