package com.team.service.productservice;

import com.team.domain.ProductDTO;

import java.util.List;


public interface ProductService {
    void insert_product(ProductDTO product);
    List<ProductDTO> select_products();
    ProductDTO select_product_by_no(Integer productNo);
}
