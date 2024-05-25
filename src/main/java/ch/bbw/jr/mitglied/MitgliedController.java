    package ch.bbw.jr.mitglied;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestParam;

    import java.lang.reflect.Member;
    import java.time.LocalDate;
    import org.springframework.format.annotation.DateTimeFormat;
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
        public String showAddMemberForm(Model model) {
            Mitglied newMember = new Mitglied();
            newMember.setEntryDate(LocalDate.now());
            model.addAttribute("newMember", newMember);
            return "addMember   ";
        }


        @GetMapping("/ergebnissFilter")
        public String filterMembers(@RequestParam("name") String name, Model model) {
            model.addAttribute("members", mitgliedService.findMembersByName(name));
            return "ergebnissFilter"; // Dies zeigt die Vorlage "filterMembers.html" an
        }
    }
