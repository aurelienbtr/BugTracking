package fr.istv.BugTracking;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import fr.istv.BugTracking.enumeration.BugEtat;
import fr.istv.BugTracking.enumeration.BugPriorite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter //Lombok
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity //JPA
public class Bug {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String titre;
	private String description;
	
	//@Enumerated(EnumType.STRING) //HAUTE BASSE NORMAL
	//private BugPriorite priorite;
	
	private String priorite;

	//@Enumerated(EnumType.STRING) // T ODO, ENCOURS, TERMINE;
	//private BugEtat etat;
	private String etat;

	
	
	@Temporal(TemporalType.DATE)
	private Date datecreation;
	
	    
	    @JsonIgnoreProperties({"commentaire"})
	    
	    @ManyToOne
	    @JsonBackReference
	    private Developpeur developpeur;
	    
	    @OneToMany
	   @JsonManagedReference //empeche les "infinis"
	    private List<Commentaire> commentaire;

	

	
}
