FROM ubuntu:latest AS build

# Instala o OpenJDK 17 e Maven
RUN apt-get update && apt-get install -y openjdk-17-jdk maven

# Define o diretório de trabalho dentro do container
WORKDIR /loja-brinquedo

# Copia o pom.xml primeiro para otimizar a construção do Docker
COPY pom.xml ./

# Copia o restante dos arquivos do projeto
COPY src ./src

# Executa o Maven para construir o projeto
RUN mvn clean install

# Listar o conteúdo do diretório target para verificação
RUN ls -l target/

# Etapa de execução
FROM openjdk:17-jdk-slim

# Expondo a porta 8080
EXPOSE 8080

# Copia o JAR gerado da etapa de construção
COPY --from=build /loja-brinquedo/target/lojaBrinquedos-0.0.1-SNAPSHOT.jar app.jar

# Define o comando de entrada
ENTRYPOINT ["java", "-jar", "app.jar"]
