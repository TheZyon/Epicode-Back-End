DROP TABLE IF EXISTS fatture;
DROP TABLE IF EXISTS clienti;

DROP TABLE IF EXISTS prodotti;
DROP TABLE IF EXISTS fornitori;

CREATE TABLE clienti(
	numeroCliente SERIAL PRIMARY KEY,
	nome VARCHAR NOT NULL,
	cognome VARCHAR NOT NULL,
	dataNascita DATE NOT NULL, /*controllare il tipo*/
	regioneResidenza VARCHAR 
);

CREATE TABLE fornitori(
	numeroFornitore SERIAL PRIMARY KEY,
	denominazione VARCHAR NOT NULL,
	regioneResidenza VARCHAR 
);

CREATE TABLE fatture(
	numeroFattura SERIAL PRIMARY KEY,
	tipologia VARCHAR NOT NULL,
	importo int8 NOT NULL,
	iva float8 NOT NULL,
	idCliente int8 NOT NULL,
	dataFattura DATE NOT NULL,
	numeroFornitore int8 NOT NULL,
	CONSTRAINT cliente_fk FOREIGN KEY(idCliente) REFERENCES clienti(numeroCliente),
	CONSTRAINT fornitore_fk FOREIGN KEY(numeroFornitore) REFERENCES fornitori(numeroFornitore)
);

CREATE TABLE prodotti(
	idProdotto SERIAL PRIMARY KEY,
	descrizione VARCHAR,
	inProduzione BOOLEAN NOT NULL,
	inCommercio BOOLEAN NOT NULL,
	dataAttivazione DATE NOT NULL,
	dataDisattivazione DATE
);

INSERT INTO clienti (nome, cognome, dataNascita) VALUES
('Mario', 'Rossi', '1982-02-02'),
('Zyon', 'Bocchiny', '1982-02-03'),
('Mariello', 'De Mariellis', '600-12-25');

INSERT INTO fornitori(denominazione) VALUES
('Epicode'), ('Bauli'), ('WheyProteinOfYoMama'), ('tuMa');

INSERT INTO fatture (tipologia, importo, iva, idCliente, dataFattura, numeroFornitore) VALUES
('costosa assai',600, 0.2, 1, '2022-01-02', 2),
('servizio sex workers', 100, 0.5, 2, '2023-01-22',4),
('farmaci dark web', 500, 0.2,3, '2021-12-04', 4 ),
('killitan', 200, 0.2, 1, '2022-01-02', 2);


INSERT INTO prodotti(descrizione, inProduzione, inCommercio, dataAttivazione, dataDisattivazione) VALUES
('sciarpina', true, true, '1999-06-06', NULL),
('lubrificante pesca', false, true ,'2017-05-22', '2023-05-03'),
('battiman dvd masterizzato', true , false, '2023-01-22', NULL),
('vestito tarocco Verace', false, false, '2017-3-17', NULL),
('coppia manette BDSM', true, false, '2017-02-05',NULL),
('bambola nonnetta arzilla', true, false, '2017-06-11', NULL),
('Chiara Ferragni', false, true, '2000-03-26', '2030-04-22'),
('pareo che parea', true, true,'1888-12-25', NULL );


SELECT nome, cognome FROM clienti
where EXTRACT(YEAR FROM dataNascita) = 1982;

/*numero fatture con iva 0.2*/	
SELECT COUNT(*) FROM fatture WHERE iva = 0.2;/*count() ---> restituisce il numero delle entities che soddisfano una certa cond*/

/*numero fatture e somma importi divisi per rispettivi anni*/
SELECT COUNT(*), SUM(f.importo/EXTRACT(YEAR FROM f.dataFattura)) FROM fatture AS f;
	
/* prodotti con data attivazione 2017 e in produzione o in commercio*/	
SELECT * from prodotti AS pr
WHERE 
EXTRACT(YEAR FROM pr.dataAttivazione)=2017 
AND (pr.inProduzione =true OR pr.inCommercio=true);

/*tra le fatture al 20%, il numero di fatture per ogni anno*/

SELECT EXTRACT(YEAR FROM dataFattura) as anno
INTO years/*tabella con gli anni delle fatture*/
FROM fatture;


