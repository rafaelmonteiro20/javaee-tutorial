package com.hello.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
public class HelloResource {

    @GET
    @Produces("text/html")
    public String hello() {
        return "<html><body><h1>Hello, World!!</h1></body></html>";
    }
    
}
