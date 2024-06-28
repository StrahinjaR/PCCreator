package konfiguracija.racunara.Controller;

import konfiguracija.racunara.Entity.Assemble;
import konfiguracija.racunara.Entity.RAM;
import konfiguracija.racunara.Entity.Storage;
import konfiguracija.racunara.Service.AssembleService;
import konfiguracija.racunara.Service.RAMService;
import konfiguracija.racunara.Service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("assemble")
@SessionAttributes({"selectedGpu", "selectedCpu", "selectedMotherboard", "selectedPsu", "selectedCase", "selectedCooler",
        "selectedGpuId", "selectedCpuId", "selectedMotherboardId", "selectedPsuId", "selectedCaseId", "selectedCoolerId", "selectedStorageIds","selectedStorages","selectedRams","selectedRamIds"})
public class PickAPartController {

    @Autowired
    private AssembleService assembleService;
    @Autowired
    private StorageService storageService;
    @Autowired
    private RAMService ramService;

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
    public String pickAPart(Model model) {
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

    @PostMapping("/pick_a_part/addGpu")
    public String addGpu(@RequestParam int gpuId,@RequestParam String gpuName, Model model) {
        model.addAttribute("selectedGpu", gpuName); // You may want to replace this with the actual GPU name
        model.addAttribute("selectedGpuId", gpuId);
        return "redirect:/assemble/pick_a_part";
    }

    @PostMapping("/pick_a_part/addCpu")
    public String addCpu(@RequestParam int cpuId,@RequestParam String cpuName, Model model) {
        model.addAttribute("selectedCpu", cpuName); // You may want to replace this with the actual GPU name
        model.addAttribute("selectedCpuId", cpuId);
        return "redirect:/assemble/pick_a_part";
    }
    @PostMapping("/pick_a_part/addPsu")
    public String addPsu(@RequestParam int psuId ,@RequestParam String psuName, Model model) {
        model.addAttribute("selectedPsuId", psuId);
        model.addAttribute("selectedPsu", psuName);
        return "redirect:/assemble/pick_a_part";
    }
    @PostMapping("/pick_a_part/addMotherboard")
    public String addMotherboard(@RequestParam int motherboardId ,@RequestParam String motherboardName, Model model) {
        model.addAttribute("selectedMotherboardId", motherboardId);
        model.addAttribute("selectedMotherboard", motherboardName);
        return "redirect:/assemble/pick_a_part";
    }
    @PostMapping("/pick_a_part/addCase")
    public String addCase(@RequestParam int caseId ,@RequestParam String caseName, Model model) {
        model.addAttribute("selectedCaseId", caseId);
        model.addAttribute("selectedCase", caseName);
        return "redirect:/assemble/pick_a_part";
    }
    @PostMapping("/pick_a_part/addCooler")
    public String addCooler(@RequestParam int coolerId ,@RequestParam String coolerName, Model model) {
        model.addAttribute("selectedCoolerId", coolerId);
        model.addAttribute("selectedCooler", coolerName);
        return "redirect:/assemble/pick_a_part";
    }

    @PostMapping("/pick_a_part/addStorage")
    public String addStorage(@RequestParam Long storageId,
                             @ModelAttribute("selectedStorageIds") List<Long> storageIds,
                             @ModelAttribute("selectedStorages") List<String> storageNames) {
        Storage storage = storageService.findById(Math.toIntExact(storageId));
        if (storage != null) {
            storageIds.add(storageId);
            storageNames.add(storage.getName());
        }
        return "redirect:/assemble/pick_a_part";
    }
    @PostMapping("/pick_a_part/addRam")
    public String addRam(@RequestParam Long ramId,
                             @ModelAttribute("selectedRamIds") List<Long> ramIds,
                             @ModelAttribute("selectedRams") List<String> ramNames) {
        RAM ram = ramService.findById(Math.toIntExact(ramId));
        if (ram != null) {
            ramIds.add(ramId);
            ramNames.add(ram.getName());
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
            }
            for (long ramId : ramIds) {
                RAM ram = ramService.findById((int) ramId);
                assemble.addRam(ram);
            }

            assembleService.saveAssemble(assemble);

            sessionStatus.setComplete();
            return "redirect:/assemble/pick_a_part";
        }
        catch (Exception ex)

        {
            System.err.println("Exception occurred while saving assembly: " + ex.getMessage());
            ex.printStackTrace();
            return "error"; // This will return the error template
        }

}}
