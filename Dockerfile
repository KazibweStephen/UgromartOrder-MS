FROM openjdk:11
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
MAINTAINER kstephen3@gmail.com
copy target/ordersms-0.0.1-SNAPSHOT.jar ordersms-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","ordersms-0.0.1-SNAPSHOT.jar"]