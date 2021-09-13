# shellcheck disable=SC2046
kill $(lsof -t -i:8090)
cp ./target/*.war /var/lib/tomcat9/webapps
/usr/share/tomcat9/bin/catalina.sh start
