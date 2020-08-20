# communication

This application was designed like Mock adapter for video on demand features and it responsible for communicate with TCP mock server.

This is a "microservice" application intended to be part of a microservice architecture in XM~ONLINE stack.

## Development

To start your application in the dev profile, run:

```
./gradlew
```

### Packaging as jar

To build the final jar and optimize the communication application for production, run:

```


./gradlew -Pprod clean bootJar

```

To ensure everything worked, run:

```


java -jar build/libs/*.jar

```

### Packaging as war

To package your application with PROD profile as a war in order to deploy it to an application server, run:

```

1 /gradlew -Pprod -Pwar clean bootWar
2 Build docker file with tag xmonline/xm-me-ms
3 Run docker container in standalone mode docker run -P 8701:8701 --name me-ms xmonline/xm-me-ms


```

## Testing

To launch your application's tests, run:

```
./gradlew test integrationTest jacocoTestReport
```

### Code quality

Sonar is used to analyse code quality. You can start a local Sonar server (accessible on http://localhost:9001) with:

```
docker-compose -f src/main/docker/sonar.yml up -d
```

You can run a Sonar analysis with using the [sonar-scanner](https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner) or by using the gradle plugin.

Then, run a Sonar analysis:

```
./gradlew -Pprod clean check jacocoTestReport sonarqube
```

For more information, refer to the [Code quality page][].

## Using Docker to simplify development (optional)

You can use Docker to improve your JHipster development experience. A number of docker-compose configuration are available in the [src/main/docker](src/main/docker) folder to launch required third party services.

For example, to start a mysql database in a docker container, run:

```
docker-compose -f src/main/docker/mysql.yml up -d
```

To stop it and remove the container, run:

```
docker-compose -f src/main/docker/mysql.yml down
```

You can also fully dockerize your application and all the services that it depends on.
To achieve this, first build a docker image of your app by running:

```
./gradlew bootJar -Pprod jibDockerBuild
```

Then run:

```
docker-compose -f src/main/docker/app.yml up -d
```

## Continuous Integration (optional)

//TODO
