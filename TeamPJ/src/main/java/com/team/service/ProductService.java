package com.team.service;

import com.team.domain.ProductDTO;
import lombok.extern.log4j.Log4j2;


public interface ProductService {
    void insertProduct(ProductDTO product);

}
