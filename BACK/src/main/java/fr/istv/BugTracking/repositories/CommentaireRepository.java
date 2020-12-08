package fr.istv.BugTracking.repositories;

import fr.istv.BugTracking.Bug;
import fr.istv.BugTracking.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {
    Optional<Commentaire> findById(Integer id);
    
    @Query("SELECT c FROM Commentaire c WHERE c.titre LIKE %?1%")
    List<Commentaire> findCommentaireByTitle(String titre);
}