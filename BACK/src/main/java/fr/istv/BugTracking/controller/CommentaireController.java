package fr.istv.BugTracking.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import fr.istv.BugTracking.*;
import fr.istv.BugTracking.repositories.*;


@RestController
public class CommentaireController {

    @Autowired
    BugRepository bugsRepository;

    @Autowired
    CommentaireRepository comRepository;

    @Autowired
    DeveloppeurRepository devsRepository;

    //Affiche les Devs en fonction de leur titre
   // @GetMapping("commentaire/{titre}")
    //public Commentaire getCommentaire(@PathVariable("titre") String titre) {
      //  return comRepository.findByString(titre).orElse(null);
    //}
    
    // Affiche la liste de tout les dev
    @GetMapping("commentaire")
    public List<Commentaire> getAllCommentaire() {
    	return comRepository.findAll();
    }
    
    //Permet d'ajouter un dev
    @PostMapping("commentaire")
    public Commentaire AddCom(@Validated @RequestBody CreateCommentaire com){
    	// Date datecrea = new Date();
    	
        return comRepository.save(
                Commentaire
                .builder()
                .message(com.getMessage())
                .titre(com.getTitre())
           //     .dateCom(datecrea)
                //.bug(dev.getBug())
                //.dev(dev.getDev())
                .build()
        );
    }
    
   
}