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
import io.swagger.annotations.ApiModelProperty;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBug {
	@ApiModelProperty("Titre du bug")
    private String titre;
	
	@ApiModelProperty("Description du bug")
    private String description;
	
	@ApiModelProperty("Priorite du bug entre HAUTE, NORMALE et BASSE")
    private String priorite;
	
	@ApiModelProperty("Etat du bug entre TODO, ENCOURS et TERMINES")
    private String etat;
    
  
    @JsonIgnoreProperties({"commentaire","developpeur"}) 
    
    @ApiModelProperty("La date où le bug a été créé")
    @Temporal(TemporalType.DATE)
    private Date datecreation;
    
    //private Developpeur developpeur;
  
    //private List<Commentaire> commentaire;
}