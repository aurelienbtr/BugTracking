package fr.istv.BugTracking;

import java.util.Date;
import java.util.List;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import fr.istv.BugTracking.enumeration.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBug {
    private String titre;
    private String description;
    private String priorite;
    private String etat;
    
  
    @JsonIgnoreProperties({"commentaire","developpeur"}) 
    
    @Temporal(TemporalType.DATE)
    
    private Date datecreation;
    
    //private Developpeur developpeur;
  
    //private List<Commentaire> commentaire;
}