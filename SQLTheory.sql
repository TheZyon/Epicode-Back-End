/*DROP DATABASE dbtest;*/
DROP TABLE IF EXISTS utente;
DROP TABLE IF EXISTS citta;

CREATE TABLE IF NOT EXISTS citta(
id SERIAL PRIMARY KEY,
nome VARCHAR NOT NULL DEFAULT '-----', /*valore di default che viene inserito se non si setta il nome*/ 
provincia VARCHAR NOT NULL,
regione VARCHAR NOT NULL
); 
/*questa tabella deve essere creata prima della tabella utente, 
perchè utente ha una foreign key collegata a citta*/

CREATE TABLE IF NOT EXISTS utente (
	id  SERIAL,
	nome VARCHAR NOT NULL,
	cognome VARCHAR NOT NULL,
	cf VARCHAR NOT NULL UNIQUE,
	citta INT8 NOT NULL,
	CONSTRAINT userpk PRIMARY KEY (id), /* to specify the primary key, we could also write "PRIMARY KEY"at row 4*/	
	CONSTRAINT citta_fk FOREIGN KEY(citta) REFERENCES citta(id)
);

/* ALTER TABLE --> modificare struttura colonne*/
/*ALTER TABLE utente ADD cf VARCHAR NOT NULL UNIQUE;*/ /*aggiunge la colonna cf, UNIQUE controlla che i codici fiscali siano tutti diversi*/
/*ALTER TABLE utente DROP COLUMN cf;*/ /*elimina la colonna cf*/
/*ALTER TABLE utente RENAME COLUMN citta TO city;*/

TRUNCATE utente; /*svuota il contenuto della tabella*/


/*DML --->camiare righe e campi delle righe*/
INSERT INTO citta ( nome, provincia, regione) VALUES
('Roma', 'Roma', 'Lazio'),
('Milano', 'Milano', 'Lombardia'),
('Palermo', 'Palermo', 'Sicilia'),
('Firenze', 'Firenze', 'Toscana'),
('Siracusa', 'Siracusa', 'Sicilia');

INSERT INTO utente (nome,cognome,citta, cf) VALUES
('Mario', 'Rossi', 1,'carbbbbb'),
('Giuseppe', 'Verdi',2, 'itsdfghjk'),
('Francesca', 'Neri',1, 'twtwtwt'),
('Mariello','Marielli', 3, 'MarMarDiGesù'),
('Carlo', 'Carli',2, 'carlibellobello'),
('Carmelo', 'Cammeli',3, 'ionentevitti');

UPDATE utente SET citta=3 where id=3;/*voglio modificare la città di Francesca Neri*/
DELETE FROM utente where id=2;


/*DQL*/

SELECT nome, cognome FROM utente
where citta=1;

SELECT nome,cognome FROM utente
WHERE nome LIKE '%ar%'; /*->tutti i nomi che hanno "ar" preceduto e seguito da qualunque cosa*/

SELECT * FROM utente
WHERE nome LIKE '_w%'; /*--> uso trattini bassi: un carattere all'inizio, seguito da una w, e poi qualunque cosa*/

SELECT * FROM utente /*->prendi tutto dalla prima tabella e scrivi solo quello che ha corrispondenza nella seconda tabella*/
INNER JOIN citta
ON utente.citta=citta.id;

SELECT * FROM utente /*-> prendi tutto dalla prima tabella e scrivi sia quello che ha la corrispondenza della seconda tabella, sia quello chje non ce l'ha*/
LEFT JOIN citta
ON utente.citta=citta.id;


SELECT * FROM utente /*...prom citta e scrivi quello che ha corrispondenza in utente e quello che non ce l'ha*/
RIGHT JOIN citta
ON utente.citta=citta.id;

SELECT * FROM utente /*prendi tutto da utente e tutto da citta e scrivi sia ciò che ha corrispondenza che ciò che non ce l'ha*/
FULL JOIN citta
ON utente.citta=citta.id;

/*specificare i campi che si vogliono vedere nel result set per evitare ambiguità (sia utente che citta hanno la colonna 'nome')*/

SELECT u.nome AS nome_utente, u.cognome, ct.nome, ct.provincia, ct.regione FROM utente AS u /*u.nome AS nome_utente ---> uso degli alias per i nomi delle colonne che si visualizzano*/
INNER JOIN citta AS ct/* AS u ---> uso degli alias*/
ON u.citta=ct.id;

SELECT * FROM citta AS ct
ORDER BY ct.nome DESC; /*DESC per evere ordine inverso*/

/*CASCADE*/

/*TRUNCATE citta cascade;*/ /*svuota citta e a cascata tutti i dati che hanno foreign key collegata a citta*/
SELECT max(citta.nome) FROM citta;
SELECT avg(id) FROM citta;

SELECT * FROM citta WHERE id BETWEEN 1 AND 3;
SELECT provincia , count(*) FROM citta GROUP BY provincia;
SELECT provincia FROM citta WHERE nome IN ('Roma', 'Milano'); /*vale anche NOT IN*/

/*Query annidata*/
SELECT * FROM utente AS u 
WHERE u.citta in (
	SELECT id FROM citta WHERE regione = 'Lazio');