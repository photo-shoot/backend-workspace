FROM openjdk:17
ADD ./build/libs/*SNAPSHOT.jar app.jar
COPY ./src/main/resources/Wallet/ /app/Wallet
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=prod"]