# SpringBoot and OpenAPI Ecommerce application

[OpenAPI reference `http://localhost:8080/api/swagger-ui/index.html`](http://localhost:8080/api/swagger-ui/index.html)

## Introduction
This project is built with an API-first Development approach to facilitate maintainability and fast adoption.
The API contract and schema is kept simple without additional JPA decorators in [api-spec.yaml](src/main/resources/api-spec.yaml) file.
To simplify updates to the API, specialized Gradle tasks are integrated into the [build.gradle](build.gradle) manifest, the developer requires only modifying the api spec.

## Development environment bootstrap:
> This project requires JDK 21
### 1. Install Java
**Debian**
`sudo apt install openjdk-21-jdk`
`sudo update-java-alternatives --list`
`sudo update-java-alternatives --set java-1.21.0-openjdk-amd64`

**MacOS**
```shell
brew tap homebrew/cask-versions
brew search openjdk
brew install --cask openjdk@21
```

>Project initializer:
https://start.spring.io/ + `Java 21 JDK` + **Spring Web Starter** + **Spring Doc Starter**

### 2. Build OpenAPI Interfaces and Models:
Run `./gradlew build` after checking the code into your local environment.
Alternatively run `./gradlew openApiGenerate` followed by `./gradlew generateJpaAnnotations`.

### 3. Start the database
Run `./db/start_postgres.sh` to spin up an ephemeral docker container with postgres.
>Optionally set `APP_ENV=prod` to prevent the Java runtime from regenerating the schema from scratch and to preserve the database state across restarts.

### 4. Start application
`./gradlew bootRun`


References:
- https://openapi-generator.tech/docs/generators/java/
- https://github.com/OpenAPITools/openapi-generator/blob/master/modules/openapi-generator-gradle-plugin/README.adoc
- https://spec.openapis.org/oas/v3.0.3