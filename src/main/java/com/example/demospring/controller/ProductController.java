package com.example.demospring.controller;

import com.example.demospring.pojo.Products;
import com.example.demospring.request.AddProductsRequest;
import com.example.demospring.request.UpdateProductsRequest;
import com.example.demospring.response.FindProductResponse;
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
    public List<Products> findAllProduct(@RequestBody Integer pageNumber, Integer pageSize){
        return productsService.findAllProducts(pageNumber,pageSize);
    }

    @PostMapping(value = "add/product")
    public Integer addProduct(@RequestBody AddProductsRequest addProductsRequest){
        return productsService.addProducts(addProductsRequest);
    }

    /*通过产品名查找产品*/
    @PostMapping(value = "Find/product/by/bookname")
    public List<FindProductResponse> findProductByBookName(@RequestBody Integer pageNumber,Integer pageSize,String bookName){
        return productsService.findProductByBookName(pageNumber,pageSize,bookName);
    }

    @DeleteMapping(value = "delete/product/by/id")
    public Integer deleteProduct(@RequestBody Integer id) {
        return productsService.deleteProducts(id);
    }

    @PostMapping(value = "update/product/by/productid")
    public Integer updateProduct(@RequestBody UpdateProductsRequest updateProductsRequest,Integer id) {
        return productsService.updateProducts(updateProductsRequest,id);
    }

    @PostMapping(value = "update/productNum/by/id")
    public Integer updatePNum(@RequestBody int num, Integer id) {
        return productsService.updatePNum(num,id);
    }

    @GetMapping(value = "select/count")
    public long count(@RequestBody String category) {
        return productsService.count(category);
    }

    @GetMapping(value = "select/book/by/id")
    public Products findBookById(@RequestBody Integer id) {
        return productsService.findBookById(id);
    }
}
