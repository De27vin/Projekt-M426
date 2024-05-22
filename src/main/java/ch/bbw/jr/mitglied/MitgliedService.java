package ch.bbw.jr.mitglied;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MitgliedService {

    @Autowired
    private MitgliedRepository mitgliedRepository;

    public List<Mitglied> getMemberList() {
        return mitgliedRepository.findAll();
    }

    public void createMember(Mitglied member) {
        mitgliedRepository.save(member);
    }
}
