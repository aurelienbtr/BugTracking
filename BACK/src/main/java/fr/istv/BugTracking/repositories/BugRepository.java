package fr.istv.BugTracking.repositories;
import java.util.Optional;

import fr.istv.BugTracking.Bug;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BugRepository extends JpaRepository<Bug, Integer> {
    Optional<Bug> findById(Integer id);
}