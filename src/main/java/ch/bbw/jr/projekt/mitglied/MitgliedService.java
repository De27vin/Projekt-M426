package ch.bbw.jr.projekt.mitglied;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MitgliedService {

    private MitgliedRepository repo;

    @Autowired
    public MitgliedService(MitgliedRepository repo) {
        this.repo = repo;
    }

    public Iterable<Mitglied> getMitgliedList() {
        return repo.findAll();
    }

    public void createMitglied(@NotNull Mitglied mitglied){
        if(mitglied.getDate() == null){
            mitglied.setDate(new Date());
        }
        repo.save(mitglied);
    }


}



