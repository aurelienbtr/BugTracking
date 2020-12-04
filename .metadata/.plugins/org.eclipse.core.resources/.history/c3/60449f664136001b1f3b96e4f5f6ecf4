package fr.istv.BugTracking;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import Bug.Bug;
import models.QQCH;

public interface BugRepository extends JpaRepository<Bug, Integer> {
  Optional<Bug> findById(Integer id);
}