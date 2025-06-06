package org.example.hexlet.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class UsersController {
    // Показать список всех пользователей
    public static void index(Context ctx) {
        var users = UserRepository.getEntities();
        var page = new UsersPage(users);
        ctx.render("users/index.jte", model("page", page));
    }

    // Показать одного пользователя
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User with id = " + id + " not found"));
        var page = new UserPage(user);
        ctx.render("users/show.jte", model("page", page));
    }

    // Показать форму создания пользователя
    public static void build(Context ctx) {
        ctx.render("users/build.jte");
    }

    // Создать нового пользователя
    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");

        var user = new User(name, email, password);
        UserRepository.save(user);
        ctx.redirect(NamedRoutes.usersPath());
    }

    // Показать форму редактирования
    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User with id = " + id + " not found"));
        var page = new UserPage(user);
        ctx.render("users/edit.jte", model("page", page));
    }

    // Обновить данные пользователя
    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();

        var name = ctx.formParam("name");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");

        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User with id = " + id + " not found"));
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        UserRepository.save(user);
        ctx.redirect(NamedRoutes.usersPath());
    }

    // Удалить пользователя
    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        UserRepository.delete(id);
        ctx.redirect(NamedRoutes.usersPath());
    }
}