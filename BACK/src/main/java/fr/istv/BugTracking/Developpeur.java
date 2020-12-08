package fr.istv.BugTracking;


import java.util.List;

import fr.istv.BugTracking.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@JsonIgnoreProperties({"bug", "commentaire"}) // qd on cree un dev avec Postman en Json, pas besoin de rentrer ca
	
	@OneToMany(mappedBy = "developpeur")
	@JsonManagedReference //empeche les "infinis"
	private List<Bug> bug;
	@OneToMany(mappedBy = "developpeur")
	@JsonManagedReference //empeche les "infinis"
	private List<Commentaire> commentaire;
}
