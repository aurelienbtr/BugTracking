package fr.istv.BugTracking;

import lombok.NoArgsConstructor;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateCommentaire{
    private String message;
    private Bug bug;
    private Developpeur dev;
//    private Date dateCom;
    private String titre;
    
}