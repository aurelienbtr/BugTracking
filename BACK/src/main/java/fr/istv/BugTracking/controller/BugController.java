package fr.istv.BugTracking.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import fr.istv.BugTracking.*;
import fr.istv.BugTracking.exception.BugIntrouvableException;

import org.springframework.http.ResponseEntity;

//import fr.istv.BugTracking.exception.ResourceNotFoundException;
import fr.istv.BugTracking.repositories.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description = "Gestion des developpeurs")
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
    

    @ApiOperation(value="Affiche les bugs en fonction de leur id")
    
    @GetMapping("bug/{id}")
    public Optional<Bug> getBugs(@PathVariable("id") Integer id) {
    	
    	Optional<Bug> bugs = bugsRepository.findById(id);
    	if(bugs==null) throw new BugIntrouvableException("Le bug avec l'id " + id + " est inexistant.");
    	

        return bugs;
    }
    
    
    @ApiOperation(value="Affiche tout les bugs")
    
    @GetMapping("bug")
    public List<Bug> getAllBugs() {
    	return bugsRepository.findAll();
    }
   
    @ApiOperation(value="Permet de cree un bug sans commentaire ni developpeur (inutile seule)")
    @PostMapping("bug")
    public Bug createBug(@Validated @RequestBody CreateBug bug){
    	Date datecrea = new Date();
        return bugsRepository.save(
                Bug
                .builder()
                .titre(bug.getTitre())
                .description(bug.getDescription())
                .priorite(bug.getPriorite())
                .etat(bug.getEtat())
                .datecreation(datecrea)
                //.developpeur(bug.getDeveloppeur())
                //.commentaire(bug.getCommentaires())
                .build()
        );
    }
    
    @ApiOperation(value="Permet d'ajouter un developpeur a un bug")
    
    @PutMapping("bug/{id}/dev/{iddev}")
    public ResponseEntity<?> ajoutDev(@PathVariable("id") Integer id,@PathVariable("iddev") Integer iddev){
    	
            Bug bug = this.bugsRepository.findById(id).map(
            		bugModifie ->{
            		Optional<Developpeur> devAjoute = this.developersRepository.findById(iddev);
            			if(devAjoute.isPresent()){
            				bugModifie.setDeveloppeur(devAjoute.get());
            					return bugsRepository.save(bugModifie);
            			}
            			else{
            				throw new RuntimeException("Developpeur non trouvé");
            				}
            			}).orElseThrow(() -> new RuntimeException("Bug non trouvé"));
            return ResponseEntity.ok(bug);
        
        }

    @ApiOperation(value="Permet de supprimer un bug avec son identifiant")
    
    @DeleteMapping("bug/{id}")
    public void deleteBug(@PathVariable Integer id){
   	bugsRepository.deleteById(id);

   }
    
    @ApiOperation(value="Permet de filtrer les bugs entre deux dates")
    @GetMapping("bug/date")
    public List<Bug> getBugBetweenTwoDate(@RequestParam("datedebut") @DateTimeFormat(pattern="yyyy-MM-dd")Date datedebut,
                                  @RequestParam("datefin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date datefin){
        return bugsRepository.findBugByDate(datedebut,datefin);
    }
    
    @ApiOperation(value="Permet de filtrer les bugs par leur titre (recherche)")
    @GetMapping("bug/titre")
    public List<Bug> getBugByTitle(@RequestParam("titre") String titre) {
    	return bugsRepository.findBugByTitle(titre);
    }
    
    
    @ApiOperation(value="Permet de filtrer les bugs par leur etat (recherche)")
    @GetMapping("bug/etat")
    public List<Bug> getBugByEtat(@RequestParam("etat") String etat) {
    	return bugsRepository.findBugByEtat(etat);
    }
    
    
    @ApiOperation(value="Permet de filtrer les bugs par leur priorite (recherche)")
    @GetMapping("bug/priorite")
    public List<Bug> getBugByPriorite(@RequestParam("priorite") String priorite) {
    	return bugsRepository.findBugByPriorite(priorite);
    }
   

   


}