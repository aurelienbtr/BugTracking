package fr.istv.BugTracking.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import fr.istv.BugTracking.Bug;
import fr.istv.BugTracking.Commentaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BugRepository extends JpaRepository<Bug, Integer> {
    Optional<Bug> findById(Integer id);
    
    @Query("SELECT b FROM Bug b WHERE b.datecreation BETWEEN ?1 AND  ?2")
    List<Bug> findBugByDate(Date datedebut, Date datefin);
    
    //@Query("SELECT b FROM Bug b WHERE b.datecreation > ?1 AND b.datecreation < ?2")
   //List<Bug> findBugByDate(Date datedebut,Date datefin);
    
    
    @Query("SELECT b FROM Bug b WHERE b.titre LIKE %?1%")
    List<Bug> findBugByTitle(String titre);
}