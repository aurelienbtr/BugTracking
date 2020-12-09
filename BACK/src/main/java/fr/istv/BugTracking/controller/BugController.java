package fr.istv.BugTracking.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import fr.istv.BugTracking.*;
import fr.istv.BugTracking.exception.ResourceNotFoundException;
import fr.istv.BugTracking.repositories.*;
@RestController
public class BugController {

    @Autowired
    BugRepository bugsRepository;

    @Autowired
    CommentaireRepository commentairesRepository;

    @Autowired
    DeveloppeurRepository developersRepository;
    
    //test des routes avec un simple string
        @RequestMapping(value="/Buug", method=RequestMethod.GET)
        public String listeBug() {
            return "Un exemple de buug";
        }
    

    //Affiche les bugs en fonction de leur id
    @GetMapping("bug/{id}")
    public Bug getBugs(@PathVariable("id") Integer id) {
        return bugsRepository.findById(id).orElse(null);
    }
    
    // Affiche la liste de tout les bug
    @GetMapping("bug")
    public List<Bug> getAllBugs() {
    	return bugsRepository.findAll();
    }
   
    
    //Permet d'ajouter un bug
    @PostMapping("bug")
    public Bug AddBug(@Validated @RequestBody CreateBug bug){
       Date datecrea = new Date(0);
        
        return bugsRepository.save(Bug
                .builder()
                .titre(bug.getTitre())
                .description(bug.getDescription())
                .priorite(bug.getPriorite())
                .etat(bug.getEtat())
                .datecreation(datecrea)
                .developpeur(bug.getDeveloppeur())
                .build()
        );
    }
    
    @DeleteMapping("bug/{id}")
    public ResponseEntity<?> deleteBugs(@PathVariable("id") Integer id) {
        if(!bugsRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pas de bug numero " + id);
        }

        return bugsRepository.findById(id)
                .map(bug -> {
                    bugsRepository.delete(bug);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Pas de bug numero " + id));
    }
    
   // @DeleteMapping("bug/{id}")
   // public void deleteBug(@PathVariable Integer id){
   //	bugsRepository.deleteById(id);

   //}
    @GetMapping("bug/date")
    public List<Bug> getBugBetweenTwoDate(@RequestParam("datedebut") @DateTimeFormat(pattern="yyyy-MM-dd")Date datedebut,
                                  @RequestParam("datefin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datefin){
        return bugsRepository.findBugByDate(datedebut,datefin);
    }
    
    @GetMapping("bug/titre")
    public List<Bug> getBugByTitle(@RequestParam("titre") String titre) {
    	return bugsRepository.findBugByTitle(titre);
    }
   

}