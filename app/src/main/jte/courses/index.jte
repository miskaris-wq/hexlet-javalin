@param org.example.hexlet.dto.courses.CoursesPage page

<!DOCTYPE html>
<html>
<head>
    <title>Курсы</title>
</head>
<body>
    <h1>Поиск курсов</h1>

    <!-- Поисковая форма с сохранением введенного значения -->
    <form action="/courses" method="get">
        <input type="search" name="term" value="${page.getTerm()}"
               placeholder="Название или описание...">
        <input type="submit" value="Найти">
    </form>

    <!-- Результаты поиска -->
    <div class="courses">
        @for(var course : page.getCourses())
            <div class="course">
                <h2>${course.getName()}</h2>
                <p>${course.getDescription()}</p>
            </div>
        @endfor
    </div>
</body>
</html>