package fr.istv.BugTracking.controller;

//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
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
//import fr.istv.BugTracking.exception.ResourceNotFoundException;
import fr.istv.BugTracking.repositories.*;
import io.swagger.annotations.ApiOperation;


@RestController

public class DeveloppeurController {

    @Autowired
    BugRepository bugsRepository;

    @Autowired
    CommentaireRepository commentairesRepository;

    @Autowired
    DeveloppeurRepository devsRepository;

    @ApiOperation(value="Permet d'afficher un developpeur par son identifiant")
    @GetMapping("/developpeur/{id}")
    public Developpeur getDeveloppeur(@PathVariable("id") Integer id) {
        return devsRepository.findById(id).orElse(null);
    }
    
    @ApiOperation(value="Permet d'afficher la liste des developpeurs")
    @GetMapping("/developpeur")
    public List<Developpeur> getAllDeveloppeur() {
    	return devsRepository.findAll();
    }
    
    @ApiOperation(value="Permet de creer un developpeur")
    @RequestMapping(value = "/developpeur", method =  RequestMethod.POST)
    public Developpeur AddDev(@Validated @RequestBody CreateDeveloppeur dev){
    	
        return devsRepository.save(
                Developpeur
                .builder()
                .nom(dev.getNom())
                .avatar(dev.getAvatar())
              //  .bug(dev.getBug())
              //  .commentaire(dev.getCommentaire())
                .build()
        );
    }
    
   
    @ApiOperation(value="Permet de supprimer un developpeur par son id")
    @DeleteMapping("/developpeur/{id}")
    public void deleteDeveloppeur(@PathVariable("id") Integer id) {
        
    	if(devsRepository.existsById(id))
    		{
    		devsRepository.deleteById(id);

    		}
    
    }
}