package by.it.academy.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

@WebServlet(name = "HelloWorld", urlPatterns = "/hello")
public class HelloWorld extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        Enumeration<String> headerNames = request.getHeaderNames();
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello World!</h1>");
        out.println(new Date());
        // Session
        out.println("<h1>Session ID: " + session.getId() + "</h1>");
        // Cookies
        if (cookies.length > 0) {
            out.println("<h1>My cookies:</h1>");
        }
        for (Cookie cookie:cookies) {
            out.println("<a>" + cookie.getName() + "=" + cookie.getValue() + "</a>");
        }
        // Headers
        out.println("<h1>My headers:</h1>");
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            out.println("<a>" + headerName + "=" + headerValue +"</a><br/>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}