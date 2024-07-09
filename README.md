### API 

[OpenAPI reference `http://localhost:8080/api/swagger-ui/index.html`](http://localhost:8080/api/swagger-ui/index.html)

### Dev environment prep:
`sudo apt install openjdk-21-jdk`
`sudo update-java-alternatives --list`
`sudo update-java-alternatives --set java-1.21.0-openjdk-amd64`

### Project prep:
https://start.spring.io/ + `Java 21 JDK` + **Spring Web Starter** + **Spring Doc Starter**

### API Interfaces built with:
`./gradlew openApiGenerate`

API spec file location: [api-spec.yaml](src/main/resources/api-spec.yaml)


**build.gradle bootstrap snapshot**
```groovy
plugins {
	id 'java'
	id 'org.springframework.boot' version '3.3.1'
	id 'io.spring.dependency-management' version '1.1.5'
	id 'org.openapi.generator' version '7.7.0'
}

group = 'com.agileengine'
version = '0.0.1-SNAPSHOT'

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom annotationProcessor
	}
}

openApiGenerate {
	inputSpec.set("$rootDir/src/main/resources/api-spec.yaml")
	outputDir = "${rootDir}"
	generatorName = "spring"
	apiPackage = "${group}.ecomm.generated.api"
	invokerPackage = "${group}.ecomm.generated.api"
	modelPackage = "${group}.ecomm.generated.model"
	configOptions = [
			library: "spring-boot",
			dateLibrary: "java8",
			hideGenerationTimestamp: "true",
			serializableModel: "true",
			openApiNullable: "false",
			useTags: "true",
			hateoas: "true",
			unhandledException: "true",
			useSpringBoot3: "true",
			useSwaggerUI: "true",
			interfaceOnly: "true",
			skipDefaultInterface: "true"
	]
}

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0'
	implementation 'javax.servlet:javax.servlet-api:4.0.1'
	implementation 'org.springframework.boot:spring-boot-starter-hateoas'
	implementation 'io.swagger.core.v3:swagger-annotations:2.2.20'
	compileOnly 'org.projectlombok:lombok'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}
```

References:
- https://openapi-generator.tech/docs/generators/java/
- https://github.com/OpenAPITools/openapi-generator/blob/master/modules/openapi-generator-gradle-plugin/README.adoc
- https://spec.openapis.org/oas/v3.0.3