package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;

import org.example.hexlet.dto.users.UsersRepository;
import org.example.hexlet.model.Course;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.User;

import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> ctx.redirect("/courses"));

        app.get("/courses", ctx -> {
            var courses = List.of(
                    new Course(1L, "course1", "test1"),
                    new Course(2L, "course2", "test2")
            );
            var header = "Курсы по программированию";
            var page = new CoursesPage(courses, header);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get("/courses/{id}", ctx -> {
            var id = Long.parseLong(ctx.pathParam("id"));
            // В реальном приложении здесь будет поиск в базе данных
            var course = new Course(id, "course" + id, "description for course " + id);
            ctx.render("courses/show.jte", model("course", course));
        });

        /*app.get("/users/{id}", ctx -> {
            String id = ctx.pathParam("id");
            Map<String, Object> model = new HashMap<>();
            model.put("id", id);
            ctx.render("users/user.jte", model);
        });

         */
        app.post("/users", ctx -> {
            var name = ctx.formParam("name").trim();
            var email = ctx.formParam("email").trim().toLowerCase();
            var password = ctx.formParam("password");
            var passwordConfirmation = ctx.formParam("passwordConfirmation");

            var user = new User(name, email, password);
            UsersRepository.save(user);
            ctx.redirect("/users");
        });


        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });

        app.start(7070);
    }
}