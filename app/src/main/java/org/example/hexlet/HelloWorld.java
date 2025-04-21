package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/users", ctx -> ctx.result("GET /users"));
        app.get("/hello", ctx -> {
            String name = ctx.queryParam("name");
            String greeting = name != null ? "Hello, " + name + "!" : "Hello, World!";
            ctx.result(greeting);
        });
        app.post("/users", ctx -> ctx.result("POST /users"));
        app.start(7070);
    }
}
