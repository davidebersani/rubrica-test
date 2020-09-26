# Rubrica
Test: realizzazione di una web application per la gestione di una rubrica.

##Tecnologie utilizzate
L'applicazione web è stata realizzata utilizzando il framework Spring MVC, con Spring Boot 2.3.4 e Java 11. 

Il database utilizzato è PostgreSQL.

##Requisiti
Per lavorare sul progetto è necessario avere:
* Java 11
* Gradle
* Docker e Docker Compose

##Eseguire il progetto
Per eseguire il progetto sono possibile due strade: la prima in cui si effettua la build dell'applicazione e la build dell'immagine Docker, e la seconda in cui si utilizza una versione già buildata dell'applicazione.

####Opzione 1
Eseguire la build del progetto con Gradle.
Per comodità si consiglia di importare il progetto in un IDE come "Progetto Gradle" e successivamente eseguire la build. Altrimenti, è possibile eseguire la build direttamente da terminale, entrando nella directory del progetto ed eseguendo il con il comando `gradle build`.

Una volta eseguita la build dell'applicazione, è necessario costruire l'immagine Docker. Dalla directory del progetto, eseguire lo script `build-images.sh` oppure, in alternativa, eseguire direttamente il comando `docker-compose -f env/env.yaml build`.

A questo punto è possibile avviare l'applicazione. Dalla directory del progetto, eseguire il seguente comando:
```
docker-compose -f env/env.yaml up -d
```
Ora sarà possibile accedere all'applicazione dal browser: http://localhost:8080 .
Se si vuole accedere al database si può usare l'interfaccia grafica disponibile all'indirizzo http://localhost:8081 e collegarlo all'istanza di Postgres, utilizzando i seguenti parametri:

* Sistema: PostgreSQL
* Server: postgres:5432
* Utente: postgres
* Password: postgres

###Opzione 2
Se non si vuole eseguire la build manuale, si può utilizzare il Jar disponibile a questo indirizzo: https://drive.google.com/file/d/17DHwVYXkxjPc1pBiak_R9dVUfDMJccVl/view?usp=sharing.

Il nome del jar è "rubrica-\<tag commit\>.jar". In questo modo si può verificare a quale commit si riferisce la build che si sta utilizzando.

Per avviare l'applicazione, la prima cosa da fare è avviare il database. Dalla directory del progetto, eseguire
```
docker-compose -f env/env.yaml up -d postgres adminer
```

Successivamente, eseguire il Jar. Assicurarsi di usare Java 11.
```
java -jar <path-to-downloaded-jar>.jar
```
Ora sarà possibile accedere all'applicazione dal browser: http://localhost:8080 .
Se si vuole accedere al database si può usare l'interfaccia grafica disponibile all'indirizzo http://localhost:8081 e collegarlo all'istanza di Postgres, utilizzando i seguenti parametri:

* Sistema: PostgreSQL
* Server: postgres:5432
* Utente: postgres
* Password: postgres