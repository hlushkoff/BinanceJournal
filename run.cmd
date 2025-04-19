set JAVA_HOME=C:\Program Files\Amazon Corretto\jdk17.0.13_11
set M2_HOME=F:\bitbot\apache-maven-3.9.9
set MAVEN_HOME=F:\bitbot\apache-maven-3.9.9
set PATH=%PATH%,C:\Program Files\Amazon Corretto\jdk17.0.13_11\bin,F:\bitbot\apache-maven-3.9.9]\bin
mvn clean package install > logs
mvn spring-boot:run
#git push heroku master