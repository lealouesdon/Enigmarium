Create table Joueur(
	id int primary key, /* id du joueur*/
	pseudo varchar(20) not null, /* pseudo du joueur*/
	mdp varchar(20) not null,/*mot de passe du joueur*/
	score int /* score total du joueur*/
);

Create table Avatar(
	idAvatar int primary key, /* id de l'avatar du joueur*/
	nomA varchar(20) not null, /*nom de l'avatar*/
	sexe varchar(10) not null, /* sexe de l'avatar*/
        avanceeQ int, /*avancee d'une quete quand avancee = nbenigmes => fin*/
        avanceeH int, /*avancee d'une histoire quand nbQuetes = avancee => fin */
        chapitre int, /*N° du chapitre*/
	foreign key (idAvatar) references Joueur(id)
);

Create table Inventaire(
	idInv int primary key, /* id de l'inventaire du joueur*/
	nbCases int not null, /* nb de cases de son inventaire*/
	foreign key (idInv) references Avatar(idAvatar)
);

Create table Cases(
	numCase int primary key /*numero de la case*/
);

Create table CAppartientI(
	idInv int, /*id de l'inventaire  auquel la case appartient*/
	numCase int, /* numero de la case de l'inventaire*/
	primary key(idInv, numCase),
	foreign key(idInv) references Inventaire(idInv),
	foreign key(numCase) references Cases(numCase)
);

Create table Objet(
	objet varchar(50) primary key /* nom de l'objet*/
);

Create table OAppartientC(
	numCase int, /*numero de la case dans laquelle se trouve l'objet*/
	objet varchar(50), /*objet se trouvant dans la case*/
	primary key(numCase, objet),
	foreign key (numCase) references Cases(numCase),
	foreign key (objet) references Objet(objet)
);

Create table Monde(
	nomM varchar(30) primary key, /*nom du monde */
	nbpers int not null /* nombre de personnages present dans le monde */
);

Create table Personnage(
	nomP varchar(30) primary key, /*nom du personnage*/
	nomM varchar(30) not null, /*nom du monde auquel il appartient*/
	histoire varchar(1000) not null, /*histoire du personnage*/
	prerequis varchar(100), /* prerequis pour acceder a l'enigme -> nom de l'enigme*/
	foreign key (nomM) references Monde(nomM)
);

Create table Enigme(
	nomE varchar(20) primary key, /*nom de l'enigme*/
	description varchar(2000) not null, /* description de l'enigme*/
	perso varchar(30), /*personnage qui propose l'enigme*/
	lastScore int, /*dernier score obtenu à l'énigme*/
	foreign key (perso) references Personnage(nomP)
);

Create table Testee( /*enigme teste et echoue */
	idJ int, /* id du joueur qui a tenté l'enigme*/
	nomE varchar(20), /*nom de l'enigme tente*/
	nbTest int, /* nombre de fois que l'enigme a ete tenté et raté*/
	primary key (idJ, nomE),
	foreign key(idJ) references Joueur(id),
	foreign key(nomE) references Enigme(nomE)
);

Create table Reussie(
	idJ int, /*id du joueur qui à reussi l'enigme*/
	nomE varchar(20), /* nom de l'enigme reussi*/
	nbReussi int, /* nombre de fois que l'enigme a ete reussi*/
	primary key (idJ, nomE),
	foreign key (idJ) references Joueur(id),
	foreign key (nomE) references Enigme(nomE)
);

Create table Histoire(
	hist int primary key, /* histoire générale*/
	nbQuetes int not null, /* nombre de quete à realiser*/
        description varchar(5000)
);

Create table Quete(
	numQuete int primary key, /*numero de la quete*/
	description varchar(5000) not null, /*description de la quete*/
	nbenigmes int not null /*nombre d'enigmes a realiser*/
);

Create table QAppartientH( /*permet le lien entre 1 quete et l'histoire générale*/
	numQuete int, /* numero de la quete à réaliser*/
	hist int, /* histoire générale*/
	primary key(numQuete, hist),
	foreign key (numQuete) references Quete(numQuete),
	foreign key(hist) references Histoire(hist) 
);

Create table EAppartientQ(
	nomE varchar(20), /*nom de l'énigme a resoudre pour faire avancer la quete*/
	numQuete int, /*numero de la quete à realiser*/
	primary key(nomE, numQuete),
	foreign key (nomE) references Enigme(nomE),
	foreign key(numQuete) references Quete(numQuete)
);

