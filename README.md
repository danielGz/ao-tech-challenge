# SpringBoot and OpenAPI Ecommerce application

[OpenAPI reference `http://localhost:8080/api/swagger-ui/index.html`](http://localhost:8080/api/swagger-ui/index.html)

## Introduction
This project was created in:

https://start.spring.io/ + `Java 21 JDK` + **Spring Web Starter** + **Spring Doc Starter** + **Spring Data JPA**

This project is built with an API-first Development approach to facilitate maintainability and fast adoption.
The API contract and schema is kept simple without additional JPA decorators in [openapi.yaml](src/main/resources/openapi.yaml) file.
To simplify updates to the API, specialized Gradle tasks are integrated into the [build.gradle](build.gradle) manifest, the developer requires only modifying the api spec.

**The entities relations are respected when working with them:**

- Creating an OrderItem without a matching Order fails.
- Deleting an Order associated with a OrderItem deletes also the OrderItem in question.
- Creating an OrderItem of a Product that doesn't exist fails.

A [postman collection](Ecomm APIs.postman_collection.json) with every endpoint is included in the repository

## Development environment bootstrap:
> This project requires JDK 21
Refer to this [document](docs/before_start.md) for development dependencies (JDK and Docker).

### 2. Build and generate OpenAPI Interfaces and Models:
Run `./gradlew build` after checking the code into your local environment.
> the build lifecycle is configured to run `openApiGenerate` followed by `generateJpaAnnotations`

> For a complete refresh run `./gradlew clearAndRegenerate`
> Relations between entities are included here [entity-relations.properties](src/main/resources/entity-relations.properties) given that openapi cannot automatically resolve them

### 3. Start the database
**Quick start:**  `docker run --name postgres-local -e POSTGRES_DB=ecomm -e POSTGRES_USER=ecomm -e POSTGRES_PASSWORD=T3st12E -p 5432:5432 -d postgres:latest`

**(Optional) Start with custom settings:**
>`./db/start_postgres.sh`
>
>Modify [db/docker-compose.yaml](prod/docker-compose.yaml) as needed
>
### 4. Run the test suite
`./gradlew test`

### 5. Start application
`./gradlew bootRun`


References:
- https://openapi-generator.tech/docs/generators/java/
- https://github.com/OpenAPITools/openapi-generator/blob/master/modules/openapi-generator-gradle-plugin/README.adoc
- https://spec.openapis.org/oas/v3.0.3

# Production Environment
In this environment the database is not ephemeral, the schema is not auto generated and the connection to the database is supplied via env vars with the spring profile=prod.
### Docker
`docker build -t agileengine/ecomm-openapi .`

**Example:**
```shell
docker run -p 8080:8080 \
-e SPRING_DATASOURCE_URL=jdbc:postgresql://db.example.com:5432/ecomm \
-e SPRING_DATASOURCE_USERNAME=ecomm \
-e SPRING_DATASOURCE_PASSWORD=T3st12E \
your-docker-image
```