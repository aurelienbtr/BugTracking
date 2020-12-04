package fr.istv.BugTracking;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import Commentaire.Commentaire;


public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {
  Optional<Commentaire> findById(Integer id);
}