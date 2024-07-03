package konfiguracija.racunara.Controller;

import konfiguracija.racunara.Entity.Assemble;
import konfiguracija.racunara.Entity.RAM;
import konfiguracija.racunara.Entity.Storage;
import konfiguracija.racunara.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("assemble")
@SessionAttributes({"selectedGpu", "selectedCpu", "selectedMotherboard", "selectedPsu", "selectedCase", "selectedCooler",
        "selectedGpuId", "selectedCpuId", "selectedMotherboardId", "selectedPsuId", "selectedCaseId", "selectedCoolerId", "selectedStorageIds","selectedStorages","selectedRams","selectedRamIds"
,"cpuPrice","gpuPrice","psuPrice","coolerPrice","motherboardPrice","storagePrice","ramPrice","casePrice"})
public class PickAPartController {

    @Autowired
    private AssembleService assembleService;
    @Autowired
    private StorageService storageService;
    @Autowired
    private RAMService ramService;
    @Autowired
    private UsersAssembleService usersAssembleService;

    @Autowired
    private CompabilityService compabilityService;

    @ModelAttribute("assemble")
    public Assemble getAssemble() {
        return new Assemble();
    }

    @ModelAttribute("selectedStorageIds")
    public List<Long> selectedStorageIds() {
        return new ArrayList<>();
    }
    @ModelAttribute("selectedRamIds")
    public List<Long> selectedRamIds()
    {return new ArrayList<>();}

    @GetMapping("/pick_a_part")
    public String pickAPart(Model model, RedirectAttributes redirectAttributes) {
        if (!model.containsAttribute("selectedGpu")) {
            model.addAttribute("selectedGpu", "None");
        }
        if (!model.containsAttribute("selectedCpu")) {
            model.addAttribute("selectedCpu", "None");
        }
        if (!model.containsAttribute("selectedMotherboard")) {
            model.addAttribute("selectedMotherboard", "None");
        }
        if (!model.containsAttribute("selectedPsu")) {
            model.addAttribute("selectedPsu", "None");
        }
        if (!model.containsAttribute("selectedCase")) {
            model.addAttribute("selectedCase", "None");
        }
        if (!model.containsAttribute("selectedCooler")) {
            model.addAttribute("selectedCooler", "None");
        }
        if (!model.containsAttribute("selectedGpuId")) {
            model.addAttribute("selectedGpuId", 0);
        }
        if (!model.containsAttribute("selectedCpuId")) {
            model.addAttribute("selectedCpuId", 0);
        }
        if (!model.containsAttribute("selectedMotherboardId")) {
            model.addAttribute("selectedMotherboardId", 0);
        }
        if (!model.containsAttribute("selectedPsuId")) {
            model.addAttribute("selectedPsuId", 0);
        }
        if (!model.containsAttribute("selectedCaseId")) {
            model.addAttribute("selectedCaseId", 0);
        }
        if (!model.containsAttribute("selectedCoolerId")) {
            model.addAttribute("selectedCoolerId", 0);
        }
        if (!model.containsAttribute("selectedStorageIds")) {
            model.addAttribute("selectedStorageIds", new ArrayList<Long>());
        }
        if (!model.containsAttribute("selectedStorages")) {
            model.addAttribute("selectedStorages", new ArrayList<String>());
        }
        if (!model.containsAttribute("selectedRamIds")) {
            model.addAttribute("selectedRamIds", new ArrayList<Long>());
        }
        if (!model.containsAttribute("selectedRams")) {
            model.addAttribute("selectedRams", new ArrayList<String>());
        }
        return "pick_a_part";
    }
    public String getLoggedInUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            return authentication.getName();
        }
        return null;
    }

    @PostMapping("/pick_a_part/addGpu")
    public String addGpu(@RequestParam int gpuId,@RequestParam String gpuName,@RequestParam int gpuPrice, Model model, RedirectAttributes redirectAttributes) {
        Integer selectedMotherboardIdd = (Integer) model.getAttribute("selectedMotherboardId");
        Integer selectedCpuIdd = (Integer) model.getAttribute("selectedCpuId");
        Integer selectedPsuIdd = (Integer) model.getAttribute("selectedPsuId");
        if(selectedPsuIdd!=0 && selectedCpuIdd!=0 && selectedMotherboardIdd !=0 && compabilityService.isWattageEnough(selectedCpuIdd,gpuId,selectedMotherboardIdd,selectedPsuIdd))
        {redirectAttributes.addFlashAttribute("wattageError","Preslabo napajanje izaberite drugo!");}
        if( selectedCpuIdd!=0 && compabilityService.isGpuBottleneck(selectedCpuIdd, gpuId))
        {redirectAttributes.addFlashAttribute("bottleneckWarning","Postoji mogućnost od bottleneck-a! Izaberite bolju grafičku kartu");}
        model.addAttribute("selectedGpu", gpuName);
        model.addAttribute("selectedGpuId", gpuId);
        model.addAttribute("gpuPrice", gpuPrice);
        return "redirect:/assemble/pick_a_part";
    }

    @PostMapping("/pick_a_part/addCpu")
    public String addCpu(@RequestParam int cpuId, @RequestParam String cpuName, @RequestParam int cpuPrice, Model model, RedirectAttributes redirectAttributes ) {
        Integer selectedMotherboardIdd = (Integer) model.getAttribute("selectedMotherboardId");
        Integer selectedGpuIdd = (Integer) model.getAttribute("selectedGpuId");
        Integer selectedPsuIdd = (Integer) model.getAttribute("selectedPsuId");
        if (selectedMotherboardIdd != 0 && !compabilityService.isSocketCompatible(cpuId, selectedMotherboardIdd))
        {redirectAttributes.addFlashAttribute("error", "Selected CPU and Motherboard are not compatible.");}
        if(selectedPsuIdd!=0 && selectedMotherboardIdd !=0 && selectedGpuIdd!=0 && compabilityService.isWattageEnough(cpuId,selectedGpuIdd,selectedMotherboardIdd,selectedPsuIdd))
        {redirectAttributes.addFlashAttribute("wattageError","Preslabo napajanje izaberite drugo!");}
        if( selectedGpuIdd!=0 && compabilityService.isCpuBottleneck(cpuId, selectedGpuIdd))
        {redirectAttributes.addFlashAttribute("bottleneckWarning","Postoji mogućnost od bottleneck-a! Izaberite bolji procesor");}
        model.addAttribute("selectedCpu", cpuName);
        model.addAttribute("selectedCpuId", cpuId);
        model.addAttribute("cpuPrice", cpuPrice);
        return "redirect:/assemble/pick_a_part";
    }
    @PostMapping("/pick_a_part/addPsu")
    public String addPsu(@RequestParam int psuId ,@RequestParam String psuName,@RequestParam int psuPrice, Model model,RedirectAttributes redirectAttributes) {
        Integer selectedMotherboardIdd = (Integer) model.getAttribute("selectedMotherboardId");
        Integer selectedGpuIdd = (Integer) model.getAttribute("selectedGpuId");
        Integer selectedCpuIdd = (Integer) model.getAttribute("selectedCpuId");
        if(selectedCpuIdd!=0 && selectedMotherboardIdd !=0 && selectedGpuIdd!=0 && compabilityService.isWattageEnough(selectedCpuIdd,selectedGpuIdd,selectedMotherboardIdd,psuId))
        {redirectAttributes.addFlashAttribute("wattageError","Preslabo napajanje izaberite drugo!");}
        model.addAttribute("selectedPsuId", psuId);
        model.addAttribute("selectedPsu", psuName);
        model.addAttribute("psuPrice", psuPrice);
        return "redirect:/assemble/pick_a_part";
    }
    @PostMapping("/pick_a_part/addMotherboard")
    public String addMotherboard(@RequestParam int motherboardId ,@RequestParam String motherboardName,@RequestParam int motherboardPrice,@RequestParam int motherboardMemorySlots ,Model model, RedirectAttributes redirectAttributes) {
        Integer selectedCpuIdd=(Integer) model.getAttribute("selectedCpuId");
        Integer selectedGpuIdd = (Integer) model.getAttribute("selectedGpuId");
        Integer selectedPsuIdd = (Integer) model.getAttribute("selectedPsuId");
        List<Long> selectedRamIds = (List<Long>) model.getAttribute("selectedRamIds");
        if(selectedCpuIdd!=0 && !compabilityService.isSocketCompatible(selectedCpuIdd,motherboardId))
        {redirectAttributes.addFlashAttribute("error", "Selected CPU and Motherboard are not compatible.");}
        if(selectedCpuIdd!=0 && selectedPsuIdd !=0 && selectedGpuIdd!=0 && compabilityService.isWattageEnough(selectedCpuIdd,selectedGpuIdd,motherboardId,selectedPsuIdd))
        {redirectAttributes.addFlashAttribute("wattageError","Preslabo napajanje izaberite drugo!");}
        if(selectedRamIds.size()/2>motherboardMemorySlots)
        {redirectAttributes.addFlashAttribute("memoryError","Previše ramova premalo mesta !");}
        for (Long ramId : selectedRamIds) {
            if (ramId != 0 && !compabilityService.isRamMBCompatible(ramId, motherboardId)) {
                redirectAttributes.addFlashAttribute("ramMotherboardError", "RAM i matična nisu kompatibilni!");
                break;
            }
        }
        model.addAttribute("selectedMotherboardId", motherboardId);
        model.addAttribute("selectedMotherboard", motherboardName);
        model.addAttribute("motherboardPrice", motherboardPrice);
        return "redirect:/assemble/pick_a_part";
    }
    @PostMapping("/pick_a_part/addCase")
    public String addCase(@RequestParam int caseId ,@RequestParam String caseName,@RequestParam int casePrice, Model model) {
        model.addAttribute("selectedCaseId", caseId);
        model.addAttribute("selectedCase", caseName);
        model.addAttribute("casePrice", casePrice);
        return "redirect:/assemble/pick_a_part";
    }
    @PostMapping("/pick_a_part/addCooler")
    public String addCooler(@RequestParam int coolerId ,@RequestParam String coolerName,@RequestParam int coolerPrice, Model model) {
        model.addAttribute("selectedCoolerId", coolerId);
        model.addAttribute("selectedCooler", coolerName);
        model.addAttribute("coolerPrice", coolerPrice);
        return "redirect:/assemble/pick_a_part";
    }

    @PostMapping("/pick_a_part/addStorage")
    public String addStorage(@RequestParam Long storageId,
                             @ModelAttribute("selectedStorageIds") List<Long> storageIds,
                             @ModelAttribute("selectedStorages") List<String> storageNames
                             /*@ModelAttribute("storagePrice") List<Integer> storagePrice*/) {
        Storage storage = storageService.findById(Math.toIntExact(storageId));
        if (storage != null) {
            storageIds.add(storageId);
            storageNames.add(storage.getName());
         /*   storagePrice.add(storage.getPrice())*/;
        }
        return "redirect:/assemble/pick_a_part";
    }
    @PostMapping("/pick_a_part/addRam")
    public String addRam(@RequestParam Long ramId,
                             @ModelAttribute("selectedRamIds") List<Long> ramIds,
                             @ModelAttribute("selectedRams") List<String> ramNames)
                            /* @ModelAttribute("ramPrice") List<Integer> ramPrice)*/ {
        RAM ram = ramService.findById(Math.toIntExact(ramId));
        if (ram != null) {
            ramIds.add(ramId);
            ramNames.add(ram.getName());
          //  ramPrice.add(ram.getPrice());
        }
        return "redirect:/assemble/pick_a_part";
    }

    @PostMapping("/save")
    public String assemble(
                           @RequestParam int cpuId,
                           @RequestParam int gpuId,
                           @RequestParam int motherboardId,
                           @RequestParam int psuId,
                           @RequestParam int caseId,
                           @RequestParam int coolerId,
                           @RequestParam int cpuPrice,
                           @RequestParam int gpuPrice,
                           @RequestParam int motherboardPrice,
                           @RequestParam int psuPrice,
                           @RequestParam int casePrice,
                           @RequestParam int coolerPrice,
                           @RequestParam String computerName,
                           @ModelAttribute("selectedStorageIds") List<Long> storageIds,
                           @ModelAttribute("selectedRamIds") List<Long> ramIds,
                           @ModelAttribute("assemble") Assemble assemble,
                           SessionStatus sessionStatus) {
        try{
            System.out.println("CPU ID: " + cpuId);
            System.out.println("GPU ID: " + gpuId);
            System.out.println("Motherboard ID: " + motherboardId);
            System.out.println("PSU ID: " + psuId);
            System.out.println("Case ID: " + caseId);
            System.out.println("Cooler ID: " + coolerId);
            System.out.println("Computer Name: " + computerName);
            int brojac;
            brojac=cpuPrice+motherboardPrice+psuPrice+casePrice+coolerPrice+gpuPrice;
            System.out.println(brojac);

            assemble.setComputerName(computerName);
            assemble.setCpuId(cpuId);
            assemble.setGpuId(gpuId);
            assemble.setMotherboardId(motherboardId);
            assemble.setPsuId(psuId);
            assemble.setCaseId(caseId);
            assemble.setCoolerId(coolerId);

            assembleService.saveAssemble(assemble);

            for (long storageId : storageIds) {
                Storage storage = storageService.findById((int) storageId);
                assemble.addStorage(storage);
                brojac=brojac+storage.getPrice();
            }
            for (long ramId : ramIds) {
                RAM ram = ramService.findById((int) ramId);
                assemble.addRam(ram);
                brojac=brojac+ram.getPrice();
            }
            assemble.setTotalPrice(brojac);
            long assembleid= assemble.getId();
            String username=getLoggedInUserDetails();
            usersAssembleService.PCsForUser(username,assembleid);
            System.out.println(assembleid);
            System.out.println(username);
            System.out.println(brojac);
            assembleService.saveAssemble(assemble);

            sessionStatus.setComplete();
            return "redirect:/assemble/pick_a_part";
        }
        catch (Exception ex)

        {
            System.err.println("Exception occurred while saving assembly: " + ex.getMessage());
            ex.printStackTrace();
            return "error";
        }

}}
