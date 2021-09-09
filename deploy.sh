cp ./target/*.war /var/lib/tomcat9/webapps
systemctl tomcat9 stop
systemctl tomcat9 start
