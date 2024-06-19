package ch.bbw.jr.mitglied;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class MitgliedController {

    @Autowired
    private MitgliedService mitgliedService;

    // Andere Controller-Methoden ...

    @GetMapping("/showMember")
    public String showMembers(Model model) {
        model.addAttribute("members", mitgliedService.getMemberList());
        return "showMember";
    }

    @GetMapping("/addMember")
    public String showAddMemberForm(Model model) {
        Mitglied newMember = new Mitglied();
        newMember.setEntryDate(LocalDate.now());
        model.addAttribute("newMember", newMember);
        return "addMember";
    }

    @PostMapping("/addMember")
    public String addMember(@ModelAttribute("newMember") Mitglied newMember, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addMember";
        }
        mitgliedService.createMember(newMember);
        return "redirect:/showMember";
    }

    @GetMapping("/ergebnissFilter")
    public String filterMembers(@RequestParam("name") String name, Model model) {
        model.addAttribute("members", mitgliedService.findMembersByName(name));
        return "ergebnissFilter";
    }

    @GetMapping("/filterMembers")
    public String showFilterMembersForm() {
        return "filterMembers";
    }

    @GetMapping("/deleteMember/{id}")
    public String deleteMember(@PathVariable Long id, Model model) {
        // Hier wird das Mitglied gelöscht
        mitgliedService.deleteMemberById(id);
        return "redirect:/filterMembers"; // Redirect zur Mitgliederliste
    }

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

}
