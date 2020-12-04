package models;

import java.util.Date;

//import javax.persistence.Temporal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBugs {
    private String titre;
    private String description;
    private String priorite;
    private String etat;

    //@Temporal(TemporalType.DATE)
    private Date creation_date;
    private Developpeur dev;
}