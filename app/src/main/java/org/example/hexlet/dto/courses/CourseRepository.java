package org.example.hexlet.dto.courses;

import org.example.hexlet.model.Course;

import java.util.List;
import java.util.stream.Collectors;

public class CourseRepository {
    private static final List<Course> courses = List.of(
            new Course(1L, "course1", "test1"),
            new Course(2L, "course2", "test2"));/* инициализация списка курсов */;

    public static List<Course> search(String term) {
        String lowerTerm = term.toLowerCase();
        return courses.stream()
                .filter(course ->
                        course.getName().toLowerCase().contains(lowerTerm) ||
                                course.getDescription().toLowerCase().contains(lowerTerm))
                .collect(Collectors.toList());
    }

    public static List<Course> getEntities() {
        return courses;
    }
}
