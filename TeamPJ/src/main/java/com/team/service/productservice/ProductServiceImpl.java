package com.team.service.productservice;

import com.team.domain.ProductDTO;
import com.team.mapper.Mapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private Mapper mapper;
    @Override
    public void insert_product(ProductDTO product) {
        mapper.insertProduct(product);
    }

    @Override
    public List<ProductDTO> select_products() {
        return mapper.selectProducts();
    }

    @Override
    public ProductDTO select_product_by_no(Integer productNo) {
        return mapper.selectProductByNo(productNo);
    }
}
