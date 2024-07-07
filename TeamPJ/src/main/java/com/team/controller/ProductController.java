package com.team.controller;

import com.team.domain.ProductDTO;
import com.team.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
@Log4j2
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/manage_product")
    public void get_manage_product() {

    }
    @GetMapping("/register_product")
    public void get_register_product() {
    }

    @PostMapping("/register_product")
    public void post_register_product(ProductDTO product){
        productService.insertProduct(product);
        log.info(product);
    }

//    주소에 /1 , /2 와 같이 여러 개 있을 경우 사용
//    @GetMapping("/{product_no}")
//    public void product_no(){
//
//    }
}
