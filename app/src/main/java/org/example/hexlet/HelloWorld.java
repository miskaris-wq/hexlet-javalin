package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;

import org.example.hexlet.dto.courses.CourseRepository;
import org.example.hexlet.model.Course;
import org.example.hexlet.dto.courses.CoursesPage;

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

        app.get("/users/{id}", ctx -> {
            String id = ctx.pathParam("id");
            Map<String, Object> model = new HashMap<>();
            model.put("id", id);
            ctx.render("users/user.jte", model);
        });

        app.get("/courses", ctx -> {
            String term = ctx.queryParam("term");
            List<Course> courses;

            if (term != null && !term.isEmpty()) {
                // Фильтрация курсов по названию и описанию
                courses = CourseRepository.search(term);
            } else {
                // Все курсы, если поиск не выполнен
                courses = CourseRepository.getEntities();
            }

            var page = new CoursesPage(courses, term);
            ctx.render("courses/index.jte", Collections.singletonMap("page", page));
        });

        app.start(7070);
    }
}