package fr.istv.BugTracking;

import java.util.Date;
import java.util.List;

//import javax.persistence.Temporal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBug {
    private String titre;
    private String description;
    private String priorite;
    private String etat;

    //@Temporal(TemporalType.DATE)
    private Date dateCreation;
    private Developpeur dev;
    private List<Commentaire> commentaire;
}