package ch.bbw.jr.mitglied;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
        return "redirect:/showMember"; // Korrekte Weiterleitung
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }
}
