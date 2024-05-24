package ch.bbw.jr.mitglied;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface MitgliedRepository extends JpaRepository<Mitglied, Long> {
    List<Mitglied> findByFirstNameContaining(String name);
    List<Mitglied> findByLastNameContaining(String name);
}

