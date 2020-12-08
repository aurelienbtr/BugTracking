package fr.istv.BugTracking;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private String priorite;
	private String etat;
	//@Temporal(TemporalType.DATE)
	//private Date dateCreation;
	
	    
	    @JsonIgnoreProperties({"commentaire"})
	    
	    @ManyToOne
	    private Developpeur developpeur;
	    
	    @OneToMany
	
	    private List<Commentaire> commentaire;

	

	
}
