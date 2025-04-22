@import org.example.hexlet.model.Course
@param Course course

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>${course.getName()}</title>
</head>
<body>
    <h1>${course.getName()}</h1>
    <p>${course.getDescription()}</p>
    <a href="/courses">Вернуться к списку</a>
</body>
</html>