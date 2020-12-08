insert into Developpeur (id_Dev,nom,avatar) values (1,'aurelie','terre');
insert into Developpeur (id_Dev,nom,avatar) values (2,'sofiane','lune');
insert into Developpeur (id_Dev,nom,avatar) values (3,'emilie','jupiter');

insert into Bug (id,description,etat,priorite,titre,developpeur_id_dev) values (1,'descriptionbug1','todo','priorite','titre1',1);
insert into Bug (id,description,etat,priorite,titre,developpeur_id_dev) values (2,'descriptionbug2','todo','priorite','titre2',2);
insert into Bug (id,description,etat,priorite,titre,developpeur_id_dev) values (3,'descriptionbug3','todo','priorite','titre3',3);

insert into Commentaire (id,message,titre,bug_id,developpeur_id_dev) values (1,'Je suis en retard sur le projet web ca craint','titrecom',1,1);
insert into Commentaire (id,message,titre,bug_id,developpeur_id_dev) values (2,'Javance','titrecom2',2,2);
insert into Commentaire (id,message,titre,bug_id,developpeur_id_dev) values (3,'Je suis en','titrecom3',3,3);
