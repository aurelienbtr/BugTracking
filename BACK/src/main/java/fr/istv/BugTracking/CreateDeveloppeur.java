package fr.istv.BugTracking;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@JsonIgnoreProperties({"bug", "commentaire"})
public class CreateDeveloppeur {
    private String nom;
    private String avatar;
  	private List<Bug> bug;
  	private List<Commentaire> commentaire;
}

