insert into Developpeur(ID_DEV,name, avatar)
values
(1,'aurelien','terre');
insert into Developpeur(ID_DEV,name, avatar)
values
(2,'sofiane','lune');
insert into Developpeur(ID_DEV,name, avatar)
values
(3,'emilie','jupiter');
insert into Bug(idBug,titre,description,priorite,etat,dateCreation,dev)
values
(1,'Bug numero uno','Pb syntaxe','HAUTE','TODO','04/12/2020',1);

insert into Bug(idBug,titre,description,priorite,etat,dateCreation,dev)
values
(2,'Bug numero deux','Pb organisation','MOYEN','TODO','04/12/2020',1);

insert into Commentaire(idCom,message,bug,dev,dateCom)
values
(1,'Je suis en retard sur le projet web, ca craint',1,1,'04/12/2020');

insert into Commentaire(idCom,message,bug,dev,dateCom)
values
(2,'Sofiane a du mal a se motiver',2,2,'04/12/2020');

insert into Commentaire(idCom,message,bug,dev,dateCom)
values
(3,'Emilie n'y comprends rien, normal elle est pas developpeuse',1,3,'04/12/2020');