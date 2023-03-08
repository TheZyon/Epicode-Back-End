--resetting db
DROP TABLE IF EXISTS prenotazione;
DROP TABLE IF EXISTS postazione;
DROP TABLE IF EXISTS edificio;
DROP TABLE IF EXISTS utente;
DROP TYPE IF EXISTS tipo;


CREATE TYPE tipo AS ENUM ('PRIVATO', 'OPENSPACE', 'SALA_RIUNIONI');
CREATE CAST (VARCHAR AS tipo) WITH INOUT AS IMPLICIT;
CREATE TABLE IF NOT EXISTS utente(
                                     id SERIAL PRIMARY KEY,
                                     username VARCHAR UNIQUE NOT NULL,
                                     nome_completo VARCHAR NOT NULL,
                                     email VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS edificio(
                                       id SERIAL PRIMARY KEY,
                                       nome VARCHAR NOT NULL,
                                       indirizzo VARCHAR NOT NULL,
                                       citta VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS postazione(
                                         id SERIAL PRIMARY KEY,
                                         descrizione VARCHAR,
                                         tipo tipo NOT NULL,
                                         numero_max_occupanti INT NOT NULL,
                                         id_edificio INT NOT NULL,
                                         CONSTRAINT id_edificio_FK FOREIGN KEY (id_edificio) REFERENCES edificio(id)
    );

CREATE TABLE IF NOT EXISTS prenotazione(
                                           id SERIAL PRIMARY KEY,
                                           id_postazione INT NOT NULL,
                                           id_utente INT NOT NULL,
                                           data DATE NOT NULL,
                                           CONSTRAINT uniqueness_1 UNIQUE (id_utente, data), -- un utente non può fare due prenotazioni per lo stesso giorno
    CONSTRAINT uniqueness_2 UNIQUE (id_postazione,data), -- una postazione non può essere prenotata due volte nello stesso giorno
    CONSTRAINT postazione_FK FOREIGN KEY (id_postazione) REFERENCES postazione(id),
    CONSTRAINT utente_FK FOREIGN KEY (id_utente) REFERENCES utente(id)
    );