FROM openjdk:11
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
MAINTAINER kstephen3@gmail.com
copy ordersms/target/ordersms-0.0.1-SNAPSHOT.jar ordersms-0.0.1-SNAPSHOT.jar
ENV JAVA_OPTS=
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar ordersms-0.0.1-SNAPSHOT.jar"]