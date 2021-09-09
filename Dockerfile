FROM jenkins/jenkins:latest
RUN "apt-get update"
RUN "apt install git -y"
RUN "apt install tomcat9"
EXPOSE 8090
CMD ["jenkins.sh", "run"]

