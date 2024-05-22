package ch.bbw.jr.projekt.mitglied;

import org.springframework.data.repository.CrudRepository;

public interface MitgliedRepository extends CrudRepository<Mitglied, Integer> {
    // Hier können Sie zusätzliche Methoden für benutzerdefinierte Abfragen definieren, falls erforderlich.
}

