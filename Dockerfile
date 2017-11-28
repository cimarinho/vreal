FROM java:8
VOLUME /tmp
ADD target/vreal-0.0.1.war
RUN bash -c 'touch target/vreal-0.0.1.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/target/vreal-0.0.1.war"]