FROM tomcat:9.0.64-jdk11-corretto
ADD target/AssessApp.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]