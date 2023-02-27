DROP TABLE IF EXISTS elemento;


CREATE TYPE periodicita AS ENUM ('SETTIMANALE', 'MENSILE', 'SEMESTRALE');

CREATE TABLE IF NOT EXISTS elemento(

	dtype VARCHAR NOT NULL,
	codice_ISBN SERIAL PRIMARY KEY,
	titolo VARCHAR NOT NULL,
	anno_pubblicazione int NOT NULL,
	numero_pagine int NOT NULL,
	
	--fields libro
	autore VARCHAR,
	genere VARCHAR,
	
	--fields rivista 
	periodicita periodicita
);


CREATE TABLE IF NOT EXISTS utente(

	numero_tessera SERIAL PRIMARY KEY,
	nome VARCHAR NOT NULL,
	cognome VARCHAR NOT NULL,
	data_nascita DATE NOT NULL

);


CREATE TABLE IF NOT EXISTS prestito(

	id SERIAL PRIMARY KEY,
	id_utente int NOT NULL,
	id_elemento_prestato int NOT NULL,
	data_inizio_prestito DATE NOT NULL,
	data_restituzione_prevista DATE NOT NULL,
	data_restituzione_effettiva DATE,
	CONSTRAINT id_utente_FK FOREIGN KEY (id_utente) REFERENCES utente(numero_tessera),
	CONSTRAINT id_elemento_prestato_FK FOREIGN KEY (id_elemento_prestato) REFERENCES elemento(codice_ISBN)
);

