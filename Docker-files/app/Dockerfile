FROM tomcat:10-jdk21
LABEL "Project"="JavaDEVProject"
LABEL "Author"="SarkaLang"

RUN rm -rf /usr/local/tomcat/webapps/*
COPY target/JavaParkingProject-v2.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
WORKDIR /usr/local/tomcat/
VOLUME /usr/local/tomcat/webapps
