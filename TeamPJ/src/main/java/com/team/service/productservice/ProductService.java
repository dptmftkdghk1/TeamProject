package com.team.service.productservice;

import com.team.domain.ProductDTO;

import java.util.List;


public interface ProductService {
    void insertProduct(ProductDTO product);
    List<ProductDTO> selectProduct();
}
