package fr.istv.BugTracking;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import models.Developpeur;


public interface DevRepository extends JpaRepository<Developpeur, Integer> {
  Optional<Developpeur> findById(Integer id);
}