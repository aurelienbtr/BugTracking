package fr.istv.BugTracking;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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

@Entity 
public class Commentaire {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
	private String message;
	private String titre;
	
	@ManyToOne
	
    private Bug bug;

    @ManyToOne
	//@JsonIgnoreProperties({"bug", "commentaire"})
    private Developpeur developpeur;
    
	//@Temporal(TemporalType.DATE)
	//private Date dateCom;
	

}
