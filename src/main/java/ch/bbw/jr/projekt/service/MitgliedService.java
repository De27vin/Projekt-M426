package ch.bbw.jr.projekt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.bbw.jr.projekt.model.Mitglied;
import ch.bbw.jr.projekt.repository.MitgliedRepository;

@Service
public class MitgliedService {

    @Autowired
    private MitgliedRepository mitgliedRepository;

    public List<Mitglied> getAllMitglieder() {
        return mitgliedRepository.findAll();
    }

    public Mitglied getMitgliedById(Long id) {
        return mitgliedRepository.findById(id).orElse(null);
    }

    public Mitglied saveMitglied(Mitglied mitglied) {
        return mitgliedRepository.save(mitglied);
    }

    public void deleteMitglied(Long id) {
        mitgliedRepository.deleteById(id);
    }
}
