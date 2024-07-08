package com.team.service.productservice;

import com.team.domain.ProductDTO;
import com.team.mapper.Mapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private Mapper mapper;
    @Override
    public void insertProduct(ProductDTO product) {
        mapper.insertProduct(product);
    }
}
