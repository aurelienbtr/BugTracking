package fr.istv.BugTracking;

import lombok.NoArgsConstructor;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateCommentaire{
	
	@ApiModelProperty("Le message en lui meme du commentaire")
    private String message;
	@ApiModelProperty("Le bug auquel il est rattache")
    private Bug bug;
	@ApiModelProperty("Le dev auquel il est rattache")
    private Developpeur dev;
	@ApiModelProperty("La date de création du commentaire")
    private Date datecom;
	@ApiModelProperty("Le titre (ou objet) du commentaire")
    private String titre;
    
}