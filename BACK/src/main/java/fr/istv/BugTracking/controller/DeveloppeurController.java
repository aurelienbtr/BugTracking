package fr.istv.BugTracking.controller;

//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import fr.istv.BugTracking.*;
import fr.istv.BugTracking.exception.ResourceNotFoundException;
import fr.istv.BugTracking.repositories.*;


@RestController

public class DeveloppeurController {

    @Autowired
    BugRepository bugsRepository;

    @Autowired
    CommentaireRepository commentairesRepository;

    @Autowired
    DeveloppeurRepository devsRepository;

    //Affiche les Devs en fonction de leur id (ca marche)
    @GetMapping("/developpeur/{id}")
    public Developpeur getDeveloppeur(@PathVariable("id") Integer id) {
        return devsRepository.findById(id).orElse(null);
    }
    
    // Affiche la liste de tout les dev(ca marche)
    @GetMapping("/developpeur")
    public List<Developpeur> getAllDeveloppeur() {
    	return devsRepository.findAll();
    }
    
    //Permet d'ajouter un dev
    @RequestMapping(value = "/developpeur", method =  RequestMethod.POST)
   // @PostMapping("/developpeur")
    public Developpeur AddDev(@Validated @RequestBody CreateDeveloppeur dev){
    	
        return devsRepository.save(
                Developpeur
                .builder()
                .nom(dev.getNom())
                .avatar(dev.getAvatar())
                .bug(dev.getBug())
                .commentaire(dev.getCommentaire())
                .build()
        );
    }
    
    
  //  @DeleteMapping("developpeur/{id}")
  //  public ResponseEntity<?> deleteDeveloppeur(@PathVariable("id") Integer id) {
  //      if(!devsRepository.existsById(id)) {
  //          throw new ResourceNotFoundException("Il n'y a pas de developpeur avec l'id" + id);
  //      }

  //      return devsRepository.findById(id)
  //      		.map(dev -> {
  //              	devsRepository.delete(dev);
  //                  return ResponseEntity.ok().build();
  //              }).orElseThrow(() -> new ResourceNotFoundException("Il n'y a pas de developpeur avec l'id" + id));
  //  }
    
    @DeleteMapping("/developpeur/{id}")
    public void deleteDeveloppeur(@PathVariable("id") Integer id) {
        
    	if(devsRepository.existsById(id))
    		{
    		devsRepository.deleteById(id);

    		}
    
    }
}