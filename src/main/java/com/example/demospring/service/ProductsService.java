package com.example.demospring.service;


import com.example.demospring.pojo.Products;
import com.example.demospring.request.AddProductsRequest;
import com.example.demospring.request.UpdateProductsRequest;
import com.example.demospring.response.FindProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductsService {
    Integer addProducts(AddProductsRequest addProductsRequest);

    Integer deleteProducts(Integer id);

    Integer updateProducts(UpdateProductsRequest updateProductsRequest, Integer id);

    List<Products> findAllProducts(Integer pageNumber,Integer pageSize);

    Integer updatePNum(int num,Integer id);

    long count(String category);

    Products findBookById(Integer id);

    List<FindProductResponse> findProductByBookName(Integer pageNum,Integer pageSize,String bookName);
}
