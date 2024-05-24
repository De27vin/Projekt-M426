package ch.bbw.jr.mitglied;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MitgliedController {

    @Autowired
    private MitgliedService mitgliedService;

    @GetMapping("/showMember")
    public String showMembers(Model model) {
        model.addAttribute("members", mitgliedService.getMemberList());
        return "showMember";
    }

    @GetMapping("/addMember")
    public String MitgliedForm(Model model) {
        model.addAttribute("member", new Mitglied());
        return "addMember";
    }

    @PostMapping("/addMember")
    public String addMember(@ModelAttribute Mitglied member) {
        mitgliedService.createMember(member);
        return "redirect:/showMember";
    }

    @GetMapping("/ergebnissFilter")
    public String filterMembers(@RequestParam("name") String name, Model model) {
        model.addAttribute("members", mitgliedService.findMembersByName(name));
        return "ergebnissFilter"; // Dies zeigt die Vorlage "filterMembers.html" an
    }
}
