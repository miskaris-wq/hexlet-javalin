package gg.jte.generated.ondemand.courses;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,10,10,12,12,12,12,12,12,12,12,12,17,19,19,21,21,21,22,22,22,24,24,27,27,27,0,0,0,0};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, org.example.hexlet.dto.courses.CoursesPage page) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html>\n<head>\n    <title>Курсы</title>\n</head>\n<body>\n    <h1>Поиск курсов</h1>\n\n    ");
		jteOutput.writeContent("\n    <form action=\"/courses\" method=\"get\">\n        <input type=\"search\" name=\"term\"");
		var __jte_html_attribute_0 = page.getTerm();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent("\n               placeholder=\"Название или описание...\">\n        <input type=\"submit\" value=\"Найти\">\n    </form>\n\n    ");
		jteOutput.writeContent("\n    <div class=\"courses\">\n        ");
		for (var course : page.getCourses()) {
			jteOutput.writeContent("\n            <div class=\"course\">\n                <h2>");
			jteOutput.setContext("h2", null);
			jteOutput.writeUserContent(course.getName());
			jteOutput.writeContent("</h2>\n                <p>");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(course.getDescription());
			jteOutput.writeContent("</p>\n            </div>\n        ");
		}
		jteOutput.writeContent("\n    </div>\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		org.example.hexlet.dto.courses.CoursesPage page = (org.example.hexlet.dto.courses.CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
