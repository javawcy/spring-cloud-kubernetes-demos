FROM javawcy/jre8:latest
MAINTAINER javawcy javawcy@outlook.com
ADD target/*jar app.jar
EXPOSE 9092 9012
ENTRYPOINT ["java","-jar","/app.jar"]