FROM openjdk:11

EXPOSE 8080

ADD build/libs/rubrica-0.0.1-SNAPSHOT.jar rubrica.jar
ADD env/start-application.sh start-application.sh
ENTRYPOINT ["sh", "start-application.sh"]