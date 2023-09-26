package by.it.academy.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "MyCookies", urlPatterns = "/mycookies")
public class MyCookies  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie myCookie = new Cookie("mycookie", "sugar_cookie");
        myCookie.setMaxAge(24 * 60 * 60);
        resp.addCookie(myCookie);
    }
}
