insert into Developpeur (id_Dev,nom,avatar) values (1,'aurelie','terre');
insert into Developpeur (id_Dev,nom,avatar) values (2,'sofiane','lune');
insert into Developpeur (id_Dev,nom,avatar) values (3,'emilie','jupiter');

insert into Bug (id,description,etat,priorite,titre,developpeur_id_dev,datecreation) values (1,'descriptionbug1','todo','priorite','titre1',1,'2020-10-08');
insert into Bug (id,description,etat,priorite,titre,developpeur_id_dev,datecreation) values (2,'descriptionbug2','todo','priorite','titre2',2,'2020-12-01');
insert into Bug (id,description,etat,priorite,titre,developpeur_id_dev,datecreation) values (3,'descriptionbug3','todo','priorite','titre3',3,'2019-01-12');

insert into Commentaire (id,message,titre,bug_id,developpeur_id_dev,dateCom) values (1,'Je suis en retard sur le projet web ca craint','titrecom',1,1,'2020-10-08');
insert into Commentaire (id,message,titre,bug_id,developpeur_id_dev,dateCom) values (2,'Javance','titrecom2',2,2,'2020-10-08');
insert into Commentaire (id,message,titre,bug_id,developpeur_id_dev,dateCom) values (3,'Je suis en','titrecom3',3,3,'2020-10-08');
