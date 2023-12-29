package by.it.academy.web;

import by.it.academy.service.ProductService;
import by.it.academy.service.model.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/add")
    public ModelAndView getAddProductPage() {
        return new ModelAndView("add-product");
    }


    @PostMapping("/add")
    public ModelAndView postNewProduct(
            @RequestParam("photo") MultipartFile file,
            ProductSpecification productSpecification) throws IOException {

        System.out.println("Add product: " + productSpecification);
        System.out.println(file.getOriginalFilename() + ": " + file.getSize());
        productService.saveNewProduct(productSpecification, file.getBytes());
        return new ModelAndView("index");
    }

    @GetMapping("/product/{id}")
    public ModelAndView getProduct(@PathVariable("id") Integer id) {
        ProductSpecification product = productService.getProductById(id);
        ModelAndView modelAndView = new ModelAndView("product-details");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @GetMapping(value = "/product/image/{id}", produces = "image/jpeg")
    public @ResponseBody byte[] getProductImage(@PathVariable("id") Integer id) {
        return productService.getProductImageById(id);
    }
}
