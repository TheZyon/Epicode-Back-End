# Esercizio sui microservizi

Un microservizio "core" fornisce dei dati (lista delle "personcine") dal suo db ad utenti autenticati. Un microservizio "consumer" espone 
un endpoint chiamando il quale il microservizio si logga al "core" e gli manda una GET request 
per ricevere le personcine del db, quindi le manda in response al client.