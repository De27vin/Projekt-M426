package ch.bbw.jr.mitglied;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MitgliedService {

    @Autowired
    private MitgliedRepository mitgliedRepository;

    // Methode zum Abrufen aller Mitglieder
    public List<Mitglied> getMemberList() {
        return mitgliedRepository.findAll();
    }

    // Methode zum Erstellen eines neuen Mitglieds
    public void createMember(Mitglied member) {
        mitgliedRepository.save(member);
    }

    // Methode zum Filtern von Mitgliedern nach Namen
    public List<Mitglied> findMembersByName(String name) {
        return mitgliedRepository.findByFirstNameContaining(name);
    }
}
