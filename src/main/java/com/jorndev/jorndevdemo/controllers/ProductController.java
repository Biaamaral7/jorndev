package com.jorndev.jorndevdemo.controllers;

import com.jorndev.jorndevdemo.models.Product;
import com.jorndev.jorndevdemo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController extends RuntimeException{

    @Autowired
    ProductService productService;

    //list products
    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    //create products
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createProduct(@RequestBody Product product) {
        productService.saveOrUpdate(product);
    }

    //view a specific product
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") int id) {

       return productService.getProductById(id);
    }

    //delete a specific product
    @DeleteMapping("/{id}")
    private void deleteProduct(@PathVariable("id") int id)
    {
        productService.delete(id);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleExceptions(HttpServletRequest request, Exception e) {
        String method = request.getMethod();
        return "Cannot" + method + " this request. Exception: " + e.getMessage();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMessageNotReadableException() {
        return "Wrong format";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleAllExceptions() {
        return "Something went wrong";
    }








}
