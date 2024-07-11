# SpringBoot and OpenAPI Ecommerce application

[OpenAPI reference `http://localhost:8080/api/swagger-ui/index.html`](http://localhost:8080/api/swagger-ui/index.html)

## Introduction
This project was created in:

https://start.spring.io/ + `Java 21 JDK` + **Spring Web Starter** + **Spring Doc Starter** + **Spring Data JPA**

This project is built with an API-first Development approach to facilitate maintainability and fast adoption.
The API contract and schema is kept simple without additional JPA decorators in [openapi.yaml](src/main/resources/openapi.yaml) file.
To simplify updates to the API, specialized Gradle tasks are integrated into the [build.gradle](build.gradle) manifest, the developer requires only modifying the api spec.

## Development environment bootstrap:
> This project requires JDK 21
Refer to this [document](docs/before_start.md) for development dependencies (JDK and Docker).

### 2. Build and generate OpenAPI Interfaces and Models:
Run `./gradlew build` after checking the code into your local environment.
> the build lifecycle is configured to run `openApiGenerate` followed by `generateJpaAnnotations`

> For a complete refresh run `./gradlew clearAndRegenerate`

### 3. Start the database
**Quick start:**  `docker run --name postgres-local -e POSTGRES_DB=ecomm -e POSTGRES_USER=ecomm -e POSTGRES_PASSWORD=T3st12E -p 5432:5432 -d postgres:latest`

**(Optional) Start with custom settings:**
>`./db/start_postgres.sh`
>
>Modify [db/docker-compose.yaml](db/docker-compose.yaml) as needed

### 4. Start application
`./gradlew bootRun`

## Prod environment execution:
### 1. Database:
>For production set `APP_ENV=prod` to prevent the Java runtime from regenerating the schema from scratch and to preserve the database state across restarts.
    
```shell
    export APP_ENV=prod
    export POSTGRES_DB=<database-name>
    export POSTGRES_USER=<username>
    export POSTGRES_PASSWORD=<password>
    ./db/start_postgres.sh
```
### 2. Application
`docker run agileengine/eccomm`

References:
- https://openapi-generator.tech/docs/generators/java/
- https://github.com/OpenAPITools/openapi-generator/blob/master/modules/openapi-generator-gradle-plugin/README.adoc
- https://spec.openapis.org/oas/v3.0.3