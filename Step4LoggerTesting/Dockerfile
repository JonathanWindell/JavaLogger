FROM openjdk:8-jdk-alpine

WORKDIR /Step4LoggerTesting

COPY . .

RUN javac -d . *.java

CMD ["java", "Main"]

EXPOSE 8080

# docker build -t step4loggertesting .