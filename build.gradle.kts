import com.rohanprabhu.gradle.plugins.kdjooq.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.1"
	id("io.spring.dependency-management") version "1.1.4"
	id("org.flywaydb.flyway") version "9.22.1"
	id("com.rohanprabhu.kotlin-dsl-jooq") version "0.4.6"
	kotlin("jvm") version "1.9.21"
	kotlin("plugin.spring") version "1.9.21"
	kotlin("plugin.jpa") version "1.9.21"
}

group = "com.tiemenv"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:2022.0.4")
    }
}

dependencies {
    // springboot
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // openapi
    implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:2.1.0")

    // database
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    runtimeOnly("org.postgresql:postgresql")
    implementation("org.jooq:jooq")
    implementation("org.jooq:jooq-codegen")
    implementation("org.flywaydb:flyway-core:9.22.3")
    jooqGeneratorRuntime("org.postgresql:postgresql:42.3.8")

    // tests
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")
    testImplementation("net.datafaker:datafaker:2.0.2")
    testImplementation("com.ninja-squad:springmockk:3.0.1")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "mockito-core")
    }

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    developmentOnly("org.springframework.boot:spring-boot-devtools")


}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

val jooqDb = mapOf(
    "url" to "jdbc:postgresql://localhost:4999/wallet",
    "schema" to "public",
    "user" to "postgres",
    "password" to "password",
    "driver" to "org.postgresql.Driver"
)

flyway {
    url = jooqDb["url"]
    user = jooqDb["user"]
    password = jooqDb["password"]
    schemas = arrayOf(jooqDb["schema"])
}

sourceSets {
    val flyway by creating {
        compileClasspath += sourceSets.main.get().compileClasspath
        runtimeClasspath += sourceSets.main.get().runtimeClasspath
    }
    main {
        output.dir(flyway.output)
    }
}

val migrationDirs = listOf(
    "$projectDir/src/main/resources/db/migration"
)
tasks.flywayMigrate {
    dependsOn("flywayClasses")
    migrationDirs.forEach { inputs.dir(it) }
    outputs.dir("${project.layout.buildDirectory}/generated/flyway")
    doFirst { delete(outputs.files) }
}


jooqGenerator {
    configuration("primary", project.java.sourceSets.getByName("main")) {
        configuration = jooqCodegenConfiguration {
            jdbc {
                username = jooqDb["user"]
                password = jooqDb["password"]
                driver = jooqDb["driver"]
                url = jooqDb["url"]
            }

            generator {
                target {
                    packageName = "com.tiemenv.digitalwallet.infrastructure.storage.jooq"
                    directory = "${project.layout.projectDirectory}/src/main/java"
                }

                database {
                    name = "org.jooq.meta.postgres.PostgresDatabase"
                    inputSchema = jooqDb["schema"]
                    includes = ".*"
                }
            }
        }
    }
}

val `jooq-codegen-primary` by project.tasks
`jooq-codegen-primary`.dependsOn("flywayMigrate")
