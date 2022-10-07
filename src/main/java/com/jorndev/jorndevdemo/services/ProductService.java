package com.jorndev.jorndevdemo.services;

import com.jorndev.jorndevdemo.models.Product;
import com.jorndev.jorndevdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct()
    {
        List<Product> products = new ArrayList<Product>();
        productRepository.findAll().forEach(product -> products.add(product));
        return products;
    }
    //getting a specific product
    public Product getProductById(int id)
    {
        return productRepository.findById(id).get();
    }
    public void saveOrUpdate(Product product)
    {
        productRepository.save(product);
    }
    //deleting a specific record
    public void delete(int id)
    {
        productRepository.deleteById(id);
    }
}


