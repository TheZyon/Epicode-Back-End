# Implementazione richieste progetto & extra


Le features richieste dal progetto sono: 

1. Che un utente possa ricercare le postazioni per tipo e città
2. che non possano esistere due prenotazioni che hanno in comune postazione e data
3. che non possano esistere due prenotazioni che hanno in comune utente e data

La 1. è implementata in r.19-20 di main/java/repository/UtenteDAORepo, ed è testata in
test/java/thezyon/gestioneprenotazioni/GestionePrenotazioniApplicationTests.java
usando un in-memory db h2 (extra).

La 2. e la 3. sono considerate nei metodi create e update di 
thezyon/gestioneprenotazioni/service/PrenotazioneService.java
che possono essere lanciati ad esempio dal runner PrenotazioneRunner.




