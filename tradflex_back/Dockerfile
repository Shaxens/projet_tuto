FROM maven:3.8.3-openjdk-17

COPY ./tradflex /tradflex

WORKDIR /tradflex
COPY ./tradflex .

RUN mvn clean install

CMD mvn spring-boot:run
