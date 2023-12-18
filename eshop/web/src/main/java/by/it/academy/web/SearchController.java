package by.it.academy.web;

import by.it.academy.service.SearchService;
import by.it.academy.service.model.ProductSpecification;
import by.it.academy.service.model.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    SearchService searchService;

    @PostMapping("/search")
    public ModelAndView getSearchResults(
            @RequestParam("search-str") String searchStr) throws SQLException, ClassNotFoundException {

        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setProductNameCriteria(searchStr);

        List<ProductSpecification> productSpecifications =
                searchService.searchProducts(searchCriteria);

        ModelAndView modelAndView = new ModelAndView("search-results");
        modelAndView.addObject("results", productSpecifications);

        return modelAndView;
    }

    @GetMapping("/search")
    public String getSearchPage() {
        return "search";
    }


}
