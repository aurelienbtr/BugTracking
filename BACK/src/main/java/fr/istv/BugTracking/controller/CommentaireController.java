package fr.istv.BugTracking.controller;

import java.util.Date;
//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import fr.istv.BugTracking.*;
import fr.istv.BugTracking.exception.ResourceNotFoundException;
import fr.istv.BugTracking.repositories.*;
import io.swagger.annotations.ApiOperation;


@RestController
public class CommentaireController {

    @Autowired
    BugRepository bugsRepository;

    @Autowired
    CommentaireRepository comRepository;

    @Autowired
    DeveloppeurRepository devsRepository;

    
    @ApiOperation(value="Permet de lister tout les commentaires")
    @GetMapping("commentaire")
    public List<Commentaire> getAllCommentaire() {
    	return comRepository.findAll();
    }
    
    
    @ApiOperation(value="Permet d'ajouter un commentaire a un bug par un developpeur")
    
    
    @PostMapping("/com/bug/{id}/dev/{iddev}")
    public ResponseEntity<?> ajoutCom(@PathVariable("id") int id, @PathVariable("iddev") int iddev,@Validated @RequestBody CreateCommentaire com) {
    	Date datecom = new Date();
            Bug bugaCommente = this.bugsRepository.findById(id).map(bugExistant -> {
                return bugExistant;
            }).orElseThrow(() -> new RuntimeException("Bug non trouvé"));
            Developpeur devQuiCommente = this.devsRepository.findById(id).map(devExistant -> {
                return devExistant;
            }).orElseThrow(() -> new RuntimeException("Dev non trouvé"));
            comRepository.save(
                    Commentaire
                            .builder()
                            .message(com.getMessage())
                            .developpeur(devQuiCommente)
                            .datecom((datecom))
                            .bug(bugaCommente)
                            .build()
            );
            return ResponseEntity.ok(com);
        }
     
    @ApiOperation(value="Permet de supprimer un commentaire par son Identifiant")
    @DeleteMapping("commentaire/{id}")
    public void deleteBug(@PathVariable Integer id){
        comRepository.deleteById(id);

    }
    
}