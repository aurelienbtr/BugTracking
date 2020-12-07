package controller;


import java.util.List;

import exception.ResourceNotFoundException;
import fr.istv.BugTracking.Bug;
import fr.istv.BugTracking.Commentaire;
import fr.istv.BugTracking.CreateBug;
import fr.istv.BugTracking.CreateCommentaire;
import repositories.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentaireController
{
    @Autowired
    CommentaireRepository CommentaireRepository;

    @GetMapping("/commentaire/{id}")
    public Commentaire getCommentaire(@PathVariable("id") Integer id)
    {
        return CommentaireRepository.findById(id).orElse(null);
    }

    @GetMapping("/commentaire")
    public List<Commentaire> getAllCommentaire()
    {
        return CommentaireRepository.findAll();
    }

    @PostMapping("commentaire")
    public Commentaire createCommentaire(@Validated @RequestBody CreateCommentaire com) {
        return CommentaireRepository.save(
                Commentaire
                        .builder()
                        .message(com.getMessage())
                        .dev(com.getDev())
                        .dateCom((com.getDateCom()))
                        .bug(com.getBug())
                        .build()
        );
    }
}