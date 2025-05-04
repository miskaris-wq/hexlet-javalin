package gg.jte.generated.ondemand.users;
public final class JtebuildGenerated {
	public static final String JTE_NAME = "users/build.jte";
	public static final int[] JTE_LINE_INFO = {27,27,27,27,27,27,27,27,27,27,27};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		jteOutput.writeContent("<form action=\"/users\" method=\"post\">\n  <div>\n    <label>\n      Имя\n      <input type=\"text\" name=\"name\" />\n    </label>\n  </div>\n  <div>\n    <label>\n      Email\n      <input type=\"email\" required name=\"email\" />\n    </label>\n  </div>\n  <div>\n    <label>\n      Пароль\n      <input type=\"password\" required name=\"password\" />\n    </label>\n  </div>\n  <div>\n    <label>\n      Подтверждение пароля\n      <input type=\"password\" required name=\"passwordConfirmation\" />\n    </label>\n  </div>\n  <input type=\"submit\" value=\"Зарегистрировать\" />\n</form>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
