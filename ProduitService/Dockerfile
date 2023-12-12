FROM openjdk:17-oracle

LABEL mentainer="belhajboubakera@gmail.com"

WORKDIR /app

COPY target/ProduitService-0.0.1-SNAPSHOT.jar /app/ProduitService.jar

ENTRYPOINT ["java", "-jar", "ProduitService.jar"]


