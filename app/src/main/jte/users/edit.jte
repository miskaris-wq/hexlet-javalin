<!-- src/main/resources/jte/users/edit.jte -->
@param org.example.hexlet.dto.users.UserPage page

<h1>Edit User</h1>

<form action="/users/${page.getUser().getId()}" method="post">
    <input type="hidden" name="_method" value="PATCH">
    <div class="form-group">
        <label for="name">Name</label>
        <input type="text" class="form-control" id="name" name="name"
               value="${page.getUser().getName()}" required>
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" id="email" name="email"
               value="${page.getUser().getEmail()}" required>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password"
               value="${page.getUser().getPassword()}" required>
    </div>
    <button type="submit" class="btn btn-primary">Update</button>
    <a href="/users/${page.getUser().getId()}" class="btn btn-secondary">Cancel</a>
</form>