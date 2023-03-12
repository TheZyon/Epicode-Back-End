# GESTIONE DISPOSITIVI

Behold dear HR visitor! My first full-stack app is born: front end made with Angular CLI 15, back end made with Spring Boot 3.
Have fun!

## Panoramica

Questa app serve a gestire l'assegnazione dei dispositivi di un'azienda. Gli utenti possono avere tre ruoli: USER, MODERATOR, ADMIN.

1. Uno USER può solo vedere i dispositivi aziendali disponibili e mandare richieste di prenotazione per aver assegnato un dispositivo*;
2. Un MODERATOR ha le facoltà di uno USER e inoltre può vedere tutti i dispositivi dell'azienda e può accettare/eliminare le richieste di prenotazione degli users**;
3. Un ADMIN può fare tutto quanto detto per un MODERATOR, inoltre può fare le operazioni di CRUD sulla tabella dispositivi;

## Front-end 

Il lato front-end è stato sviluppato nella cartella GestioneDispositivi_FrontEnd
con il framework Angular CLI 15.



---> nice to have: un ADMIN può sospendere l'account di uno user, impedendo il login per tot tempo.
___
(*) quando uno user fa una prenotazione, lo stato del dispositivo prenotato passa a DISMESSO;

(**) l'accettazione di una richiesta innesca il processo di assegnazione di un dispositivo ad uno USER, 
la quale se va a buon fine fa passare lo stato del dispositivo ad ASSEGNATO;
