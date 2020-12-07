package repositories;


import fr.istv.BugTracking.Commentaire;
import fr.istv.BugTracking.Developpeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeveloppeurRepository extends JpaRepository<Developpeur, Integer> {
    Optional<Developpeur> findById(Integer id);
}