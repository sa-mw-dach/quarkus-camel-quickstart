# Camel with Quarkus - A Getting Started Guide

## Prerequisites

Setup Maven 3.3.5 and GraalVM, see also https://quarkus.io/guides/getting-started-guide.

## Steps

The below outlined steps document how this project has been created and is for learning purposes. If you want to just run the examples, go straight to **Build locally**.

This project also contains some PMD checks for Quarkus to detect possible issues when porting an 
### Create quickstart project

mvn io.quarkus:quarkus-maven-plugin:0.12.0:create \
    -DprojectGroupId=quarkus.io \
    -DprojectArtifactId=camel-quickstart \
    -DprojectVersion=1.0-SNAPSHOT \
    -DclassName="io.quarkus.CamelResource"
cd camel-quickstart
mvn quarkus:add-extension -Dextensions="io.quarkus:quarkus-camel-core"

### Create sample RouteBuilder

Create *src/main/java/io/quarkus/CamelRouteBuilder.java*

    package io.quarkus;
    
    import org.apache.camel.builder.RouteBuilder;
        
    public class CamelRouteBuilder extends RouteBuilder {
      public void configure() throws Exception {
        from("timer:test")
        .log("Test 123");
      }
    }


### Configure

Modify *src/main/resources/META-INF/microprofile-config.properties*

    camel.routes.dump=true
    camel.routes.locations=

### Build locally

    mvn compile quarkus:dev
    mvn clean package
    mvn package -Pnative

### Execute Java binary

    java -jar target/camel-quickstart-1.0-SNAPSHOT-runner.jar

### Execute Native binary

    ./target/camel-quickstart-1.0-SNAPSHOT-runner

### Run code-check

    mvn pmd:check
    mvn pmd:pmd site
