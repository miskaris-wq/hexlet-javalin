package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;
import org.example.hexlet.model.Course;
import org.example.hexlet.dto.courses.CoursesPage;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // Список курсов
        app.get("/courses", ctx -> {
            var courses = List.of(
                    new Course(1L, "Основы Java", "Изучение базового синтаксиса Java"),
                    new Course(2L, "Веб-разработка", "Создание веб-приложений на Java")
            );
            var page = new CoursesPage(courses, "Наши курсы");
            ctx.render("courses/index.jte", model("page", page));
        });

        // Страница курса
        app.get("/courses/{id}", ctx -> {
            try {
                long id = Long.parseLong(ctx.pathParam("id"));
                // Имитация поиска курса
                var course = new Course(id, "Курс " + id, "Описание курса " + id);
                ctx.render("courses/show.jte", model("course", course));
            } catch (NumberFormatException e) {
                ctx.status(400).result("Неверный ID курса");
            }
        });

        app.start(7070);
    }
}