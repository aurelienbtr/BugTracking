package fr.istv.BugTracking.repositories;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import fr.istv.BugTracking.Bug;
import fr.istv.BugTracking.Commentaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BugRepository extends JpaRepository<Bug, Integer> {
    Optional<Bug> findById(Integer id);
    
    
  //  @Query("SELECT b  FROM Bug b  WHERE b.datecreation BETWEEN = :date1 AND = :date2")
  //  List<Bug> findBugBetween(Date date1, Date date2);
    
}