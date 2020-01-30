package com.example.demospring.service;


import com.example.demospring.pojo.Products;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductsService {
    Integer addProducts(Products products);

    Integer deleteProducts(Integer id);

    Integer updateProducts(Products products);

    List<Products> findAllProducts(Integer pageNumber,Integer pageSize);

    Integer updatePNum(int num,Integer id);

    long count(String category);

    Products findBookById(Integer id);
}
