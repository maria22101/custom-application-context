package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebServlet("/name")
public class NameServlet extends HttpServlet {
    public static final String SPRING_APP_CONTEXT = "SPRING_APP_CONTEXT";

    @Override
    public void init(ServletConfig config) throws ServletException {
        var springContext = new AnnotationConfigApplicationContext(NameProvider.class);
        var servletContext = config.getServletContext();
        servletContext.setAttribute(SPRING_APP_CONTEXT, springContext);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var springContext = req.getServletContext().getAttribute(SPRING_APP_CONTEXT);
        var nameProvider = ((ApplicationContext) springContext).getBean(NameProvider.class);
        resp.getWriter().println(nameProvider.getName());
    }
}
