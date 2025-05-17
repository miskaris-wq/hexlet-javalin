<!-- src/main/resources/jte/users/index.jte -->
@param org.example.hexlet.dto.users.UsersPage page

<h1>Users List</h1>

@if(page.getFlashMessage() != null)
<div class="alert alert-success">
    ${page.getFlashMessage()}
</div>
@endif

<table class="table">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        @for(var user : page.getUsers())
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getName()}</td>
            <td>${user.getEmail()}</td>
            <td>
                <a href="/users/${user.getId()}" class="btn btn-info">Show</a>
                <a href="/users/${user.getId()}/edit" class="btn btn-warning">Edit</a>
                <form action="/users/${user.getId()}" method="post" style="display: inline;">
                    <input type="hidden" name="_method" value="DELETE">
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>
            </td>
        </tr>
        @endfor
    </tbody>
</table>

<a href="/users/build" class="btn btn-primary">Create New User</a>