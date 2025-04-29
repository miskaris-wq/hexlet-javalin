@import org.example.hexlet.model.Course
@param Course course

<html>
    <head>
        <title>${course.getName()}</title>
    </head>
    <body>
        <h1>${course.getName()}</h1>
        <p>${course.getDescription()}</p>
        <a href="/courses">Назад к списку курсов</a>
    </body>
</html>