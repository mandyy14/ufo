package org.example.ovnis;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/sightings")
public class UfoSightingController {

    private final UfoSightingService sightingService;

    public UfoSightingController(UfoSightingService sightingService) {
        this.sightingService = sightingService;
    }

    @GetMapping
    public String index(Model model){
        var sightings = sightingService.getAll();
        model.addAttribute("sightings", sightings);
        return "sightings/index";
    }

    // ✅ Adiciona "sighting" no Model para o form
    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("sighting", new UfoSighting());
        return "sightings/form";
    }

    // ✅ Usa o MESMO nome do th:object no POST
    @PostMapping("/form")
    public String save(@ModelAttribute("sighting") UfoSighting sighting,
                       RedirectAttributes redirect){
        sightingService.save(sighting);
        redirect.addFlashAttribute("message", "UFO(OVNI) cadastrado com sucesso!");
        return "redirect:/sightings";
    }
}
