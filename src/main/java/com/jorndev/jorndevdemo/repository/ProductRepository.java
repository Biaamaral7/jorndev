package com.jorndev.jorndevdemo.repository;

import com.jorndev.jorndevdemo.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
