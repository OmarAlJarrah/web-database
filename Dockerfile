# Set use as root
USER root

# Install packages
RUN apt-get update && \
    && apt install tomcat9 -y \
    && apt install tomcat9-admin -y \
    && apt intsall tomcat9-user -y \
    && apt install git -y \
    && apt install wget -y \
    && apt install python3 -y

# Configure Tomcat9
RUN ln -s /var/lib/tomcat9/conf conf \
    && ln -s /var/log/tomcat9 log \
    && ln -s /etc/tomcat9/policy.d/03catalina.policy conf/catalina.policy

# Continuing config stage using a python script (uploaded on github)
RUN git clone https://github.com/omar2682000/temporary-repo.git \
    && python3 /temporary-repo/script.py \
    rm -rf /temporary-repo/script.py

# Exposing ports
EXPOSE 8080/tcp
EXPOSE 8090/tcp
