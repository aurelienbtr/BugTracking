package fr.istv.BugTracking;


import java.util.List;

import fr.istv.BugTracking.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

public class Developpeur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDev;
	private String nom;
	private String avatar; 
	
	@JsonIgnoreProperties({"bug", "commentaire"})
	
	@OneToMany
	private List<Bug> bug;
	@OneToMany
	private List<Commentaire> commentaire;
}
