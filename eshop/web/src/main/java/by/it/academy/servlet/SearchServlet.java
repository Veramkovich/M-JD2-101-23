package by.it.academy.servlet;

import by.it.academy.service.SearchService;
import by.it.academy.service.model.ProductSpecification;
import by.it.academy.service.model.SearchCriteria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "search", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

    SearchService searchService;

    @Override
    public void init() {
        searchService = new SearchService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. read request parameters
        String searchStr = req.getParameter("search-str");
        System.out.println("Search query string: " + searchStr);

        //2. create query for search
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setProductNameCriteria(searchStr);

        //3. send query to search service
        List<ProductSpecification> productSpecifications;
        try {
            productSpecifications = searchService.searchProducts(searchCriteria);
        } catch (ClassNotFoundException|SQLException e) {
            throw new ServletException(e);
        }

        //4. get list of search results
        req.setAttribute("results", productSpecifications);
        System.out.println("Search result size: " + productSpecifications.size());

        //5. show search results on view
        req.getServletContext().getRequestDispatcher("/search-results.jsp")
                .forward(req, resp);
    }
}
