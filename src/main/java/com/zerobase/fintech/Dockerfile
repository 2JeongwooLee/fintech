FROM openjdk:11-jre-slim
COPY build/libs/fintech-0.0.1-SNAPSHOT.jar fintech-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-DSpring.profiles.active=prod","-jar","fintech.jar"]