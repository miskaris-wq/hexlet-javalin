  @import org.example.hexlet.dto.users.BuildUserPage
  @param BuildUserPage page

  @if(page.getErrors() != null)
      <ul>
          @for(var validator : page.getErrors().values())
              @for(var error : validator)
                  <li>${error.getMessage()}</li>
              @endfor
          @endfor
      </ul>
  @endif

<form action="/users" method="post">
  <div>
    <label>
      Имя
      <input type="text" name="name" />
    </label>
  </div>
  <div>
    <label>
      Email
      <input type="email" required name="email" />
    </label>
  </div>
  <div>
    <label>
      Пароль
      <input type="password" required name="password" />
    </label>
  </div>
  <div>
    <label>
      Подтверждение пароля
      <input type="password" required name="passwordConfirmation" />
    </label>
  </div>
  <input type="submit" value="Зарегистрировать" />
</form>
