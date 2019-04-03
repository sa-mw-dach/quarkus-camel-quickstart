package io.quarkus;

import org.apache.camel.builder.RouteBuilder;

public class CamelRouteBuilder extends RouteBuilder {

    public void configure() throws Exception {
        from("timer:test")
        .log("Test 123");
    }
}
