/*--------------------------------MONDE------------------------------------------*/
insert into Monde(nomM, nbpers, prerequis) values("Monde des cuisiniers", 3, null);
insert into Monde(nomM, nbpers, prerequis) values ("Monde des archéologues", 5, null);
insert into Monde(nomM, nbpers, prerequis) values ("Le refuge", 2, null);
/*------------------------------------------------------------------------------*/

/*------------------------------PERSONNAGES-------------------------------------*/
insert into Personnage(nomP, nomM, histoire, prerequis) values ("André", "Monde des cuisiniers", null, null);
insert into Personnage(nomP, nomM, histoire, prerequis) values ("Bérengère", "Monde des cuisiniers", null, null);
insert into Personnage(nomP, nomM, histoire, prerequis) values ("Yvan", "Monde des cuisiniers", null, null);
/*------------------------------------------------------------------------------*/

/*------------------------------ENIGME------------------------------------------*/
insert into Enigme(nomE, description, perso, lastScore) values ("Enigme 1", "Assembler les pots et ingredients en fonction de la quantité et de la taille des pots", "André", null);
insert into Enigme(nomE, description, perso, lastScore) values ("Enigme 2", "Assembler les pots et ingredients en fonction de la quantité et de la taille des pots", "André", null);
/*-------------------------------------------------------------------------------*/

/*-------------------------------Quete-------------------------------------------*/

/*-------------------------------------------------------------------------------*/

/*----------------------------------Histoire-------------------------------------*/
insert into Histoire(hist, nbQuetes, avancee) values ("", ,null);
/*---------------------------------------------------------------------------------*/