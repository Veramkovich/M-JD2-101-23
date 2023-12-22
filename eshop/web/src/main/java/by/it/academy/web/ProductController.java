package by.it.academy.web;

import by.it.academy.service.model.ProductSpecification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @GetMapping("/add")
    public ModelAndView getAddProductPage() {
        return new ModelAndView("add-product");
    }


    @PostMapping("/add")
    public ModelAndView postNewProduct(
            @RequestParam("photo") MultipartFile file,
            ProductSpecification productSpecification) {

        System.out.println("Add product: " + productSpecification);
        System.out.println(file.getOriginalFilename() + ": " + file.getSize());

        return new ModelAndView("index");
    }
}
