package io.quarkus;

import org.apache.camel.builder.RouteBuilder;
import sun.misc.Unsafe;


public class CamelRouteBuilder extends RouteBuilder {

	{
        // Not supported (fully) by GraalVM!
	}

    public void configure() throws Exception {
        from("timer:test")
        .log("Test 123");
    }

    public void finalize() {
        // GraalVM will never call this!
        Unsafe unsafe = null;
    }
}
