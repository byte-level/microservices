# Docker - Java Redis
A Docker container with Java and Redis.
This can be used to build-up Java and Redis self contained applications running in a Docker container.

## Configure environment
- Install [sdkman](https://sdkman.io/)
- Commands to list java versions

```
sdk list java
sdk install java 17.0.3-oracle
sdk use java 17.0.3-oracle
```

Now the java version would be set to `17`.

```
java -version
java version "17.0.3" 2022-04-19 LTS
Java(TM) SE Runtime Environment (build 17.0.3+8-LTS-111)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.3+8-LTS-111, mixed mode, sharing)
```

# Build docker image
docker build -t redis .

# Run docker image
docker run -dp 3000:3000 redis

# multi-module setup
```
mvn archetype:generate -DgroupId=com.microservice -DartifactId=parent-project

mvn archetype:generate -DgroupId=com.microservice -DartifactId=redis
mvn archetype:generate -DgroupId=com.microservice -DartifactId=cassandra
mvn archetype:generate -DgroupId=com.microservice -DartifactId=app
```

## Building the project
#### Ported from https://github.com/nerfologist/dropwizard-restful-api/edit/master/README.md
`mvn clean package [-DskipTests]`

## Starting the server
`java -jar target/app-1.0-SNAPSHOT.jar server config.yml`

## Example calls
```
GET localhost:8080/contacts
GET localhost:8080/contacts/1
DELETE localhost:8080/contacts/1
POST localhost:8080/contacts
PUT localhost:8080/contacts/1
```


