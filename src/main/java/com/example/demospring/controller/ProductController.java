package com.example.demospring.controller;

import com.example.demospring.pojo.Products;
import com.example.demospring.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Component
@RestController
public class ProductController {
    @Autowired
    private ProductsService productsService;
    @GetMapping(value = "find/all/product")
    public List<Products> findAllProduct(Integer pageNumber, Integer pageSize){
        return productsService.findAllProducts(pageNumber,pageSize);
    }

    @PostMapping(value = "add/product")
    public Integer addProduct(@RequestBody Products products){
        return productsService.addProducts(products);
    }



    @DeleteMapping(value = "delete/product/by/id")
    public Integer deleteProduct(@RequestBody Integer id) {
        return productsService.deleteProducts(id);
    }

    @PostMapping(value = "update/product/by/product")
    public Integer updateProduct(@RequestBody Products products) {
        return productsService.updateProducts(products);
    }

    @PostMapping(value = "update/productNum/by/id")
    public Integer updatePNum(int num, Integer id) {
        return productsService.updatePNum(num,id);
    }

    @GetMapping(value = "select/count")
    public long count(String category) {
        return productsService.count(category);
    }

    @GetMapping(value = "select/book/by/id")
    public Products findBookById(Integer id) {
        return productsService.findBookById(id);
    }
}
