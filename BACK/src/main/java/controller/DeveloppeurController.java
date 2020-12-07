package controller;

import java.util.List;

import exception.ResourceNotFoundException;
import fr.istv.BugTracking.Commentaire;
import fr.istv.BugTracking.Bug;
import fr.istv.BugTracking.CreateBug;
import fr.istv.BugTracking.CreateCommentaire;
import fr.istv.BugTracking.CreateDeveloppeur;
import fr.istv.BugTracking.Developpeur;
import repositories.DeveloppeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeveloppeurController
{
    @Autowired
    DeveloppeurRepository DeveloppeurRepository;

    @GetMapping(value= "/developpeur/{id}")
    public Developpeur getDeveloppeur(@PathVariable int id)
    {
    	return DeveloppeurRepository.findById(id).orElse(null);
    }

    @GetMapping(value ="developpeur")
    public List<Developpeur> getAllDeveloppeur()
    {
        return DeveloppeurRepository.findAll();
    }

    @PostMapping("/developpeur")
    public Developpeur createDeveloppeur(@Validated @RequestBody CreateDeveloppeur dev) {
        return DeveloppeurRepository.save(
                Developpeur
                        .builder()
                        .nom(dev.getNom())
                        .avatar(dev.getAvatar())
                        //.bug(dev.getBug())
                        //.commentaire(dev.getCommentaire())
                        .build()
        );
    }
}