# localghosts

How to start the localghosts application
---

1. Run `mvn clean install` to build your application
2. Start application with `java -jar target/localghosts-1.0-SNAPSHOT.jar server config.yml`
3. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
