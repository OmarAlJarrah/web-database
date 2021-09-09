# DevOps
## Docker 
+ I used a Dockerfile, depending on the official Jenkins docker image to create a docker container, that is to be
used as a container for my application, the container has the following extensions:
    - Tomcat 9 server.
    - Jenkins.
    - Git.
```
FROM jenkins/jenkins:latest
RUN "apt-get update"
RUN "apt install git -y"
RUN "apt install tomcat9 -y"
EXPOSE 8090
CMD ["jenkins.sh", "run"]
```

## Jenkins
+ I used Jenkins as a CI/CD tool, configuring it to build the project with each commit made to the github repository.
```
SCM:
* * * * *
```

+ I used maven plugin to handle building the project, producing a war file for each build.
```
[maven goals]
clean install package
```

+ I used a bash script to deploy my application to local tomcat9 server (local on the container itself).
```
cp ./target/*.war /var/lib/tomcat9/webapps
systemctl tomcat9 stop
systemctl tomcat9 start
```