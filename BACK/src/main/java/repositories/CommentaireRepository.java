package repositories;

import fr.istv.BugTracking.Bug;
import fr.istv.BugTracking.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {
    Optional<Commentaire> findById(Integer id);
}