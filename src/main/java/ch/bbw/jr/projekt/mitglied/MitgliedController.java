package ch.bbw.jr.projekt.mitglied;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MitgliedController {

    @Autowired
    private MitgliedService mitgliedService;

    @GetMapping("/showMitglied")
    public String showJokes(Model model) {
        model.addAttribute("mitgliedlist", mitgliedService.getMitgliedList());
        return "showMitglied";
    }

    @GetMapping("/addMitglied")
    public String MitgliedForm(Model model) {
        model.addAttribute("mitglied", new Mitglied());
        return "addMitglied";
    }

    @PostMapping("/addMitglied")
    public String addMitglied(@ModelAttribute Mitglied mitglied) {
        mitgliedService.createMitglied(mitglied);
        return "redirect:/showMitglied"; // Korrekte Weiterleitung
    }

}
