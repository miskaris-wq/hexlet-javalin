<!-- src/main/resources/jte/users/show.jte -->
@param org.example.hexlet.dto.users.UserPage page

<h1>User Details</h1>

<div class="card">
    <div class="card-body">
        <h5 class="card-title">${page.getUser().getName()}</h5>
        <p class="card-text">
            <strong>ID:</strong> ${page.getUser().getId()}<br>
            <strong>Email:</strong> ${page.getUser().getEmail()}<br>
            <strong>Password:</strong> ********
        </p>
        <a href="/users/${page.getUser().getId()}/edit" class="btn btn-warning">Edit</a>
        <form action="/users/${page.getUser().getId()}" method="post" style="display: inline;">
            <input type="hidden" name="_method" value="DELETE">
            <button type="submit" class="btn btn-danger">Delete</button>
        </form>
        <a href="/users" class="btn btn-secondary">Back to list</a>
    </div>
</div>