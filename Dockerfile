FROM jenkins/jenkins:jdk11

# Set use as root
USER root

# Install packages
RUN apt-get update && \
    apt install maven -y \
    && apt install tomcat9 -y \
    && apt install git -y \
    && apt install wget -y \
    && apt install python3 -y

# Configure Tomcat9
RUN ln -s /var/lib/tomcat9/conf conf \
    && ln -s /var/log/tomcat9 log \
    && ln -s /etc/tomcat9/policy.d/03catalina.policy conf/catalina.policy

# Continuing config stage using a python script (uploaded on a cloud storage)
RUN git clone https://github.com/omar2682000/temporary-repo.git \
    && python3 /temporary-repo/script.py \
    rm -rf /temporary-repo/script.py