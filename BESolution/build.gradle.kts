plugins {
    kotlin("jvm") version "1.9.22"
    id("com.google.protobuf") version "0.9.4"
    application
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

val grpcVersion = "1.64.0"
val protobufVersion = "3.25.3"
val nakamaGrpcVersion = "3.20.0"

dependencies {
    implementation(kotlin("stdlib"))

    implementation("com.github.heroiclabs.nakama-java:nakama-java:2.5.3")

    // gRPC & Protobuf
    implementation("io.grpc:grpc-netty-shaded:$grpcVersion")
    implementation("io.grpc:grpc-protobuf:$grpcVersion")
    implementation("io.grpc:grpc-stub:$grpcVersion")
    implementation("com.google.protobuf:protobuf-java:$protobufVersion")

    // Optional: Logging
    implementation("ch.qos.logback:logback-classic:1.4.11")
}

// For Java 17 support
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

// Protobuf code generation
protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$protobufVersion"
    }
    plugins {
        create("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:$grpcVersion"
        }
    }
    generateProtoTasks {
        all().forEach { task ->
            task.plugins {
                create("grpc")
            }
        }
    }
}


sourceSets {
    main {
        proto {
            srcDir("src/main/proto")
        }
    }
}

application {
    mainClass.set("com.example.MainKt")
}
