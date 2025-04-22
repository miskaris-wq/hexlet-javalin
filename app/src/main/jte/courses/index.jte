@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Список курсов</title>
</head>
<body>
    <h1>${page.getHeader()}</h1>

    @if(page.getCourses().isEmpty())
        <p>Курсы пока не добавлены</p>
    @else
        <ul>
        @for(var course : page.getCourses())
            <li>
                <h2>
                    <a href="/courses/${course.getId()}">${course.getName()}</a>
                </h2>
                <p>${course.getDescription()}</p>
            </li>
        @endfor
        </ul>
    @endif
</body>
</html>