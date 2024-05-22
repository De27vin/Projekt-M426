package ch.bbw.jr.projekt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.bbw.jr.projekt.model.Mitglied;
import ch.bbw.jr.projekt.service.MitgliedService;

@RestController
@RequestMapping("/mitglieder")
public class MitgliedController {

    @Autowired
    private MitgliedService mitgliedService;

    @GetMapping
    public List<Mitglied> getAllMitglieder() {
        return mitgliedService.getAllMitglieder();
    }

    @GetMapping("/{id}")
    public Mitglied getMitgliedById(@PathVariable Long id) {
        return mitgliedService.getMitgliedById(id);
    }

    @PostMapping
    public Mitglied createMitglied(@RequestBody Mitglied mitglied) {
        return mitgliedService.saveMitglied(mitglied);
    }

    @DeleteMapping("/{id}")
    public void deleteMitglied(@PathVariable Long id) {
        mitgliedService.deleteMitglied(id);
    }
}

//test
