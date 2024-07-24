package com.team.service.productservice;

import com.team.domain.EmployeeDTO;
import com.team.domain.ProductDTO;
import com.team.mapper.Mapper;
import com.team.mapper.ProductMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductMapper productMapper;
    @Override
    public void insert_product(ProductDTO product) {
        productMapper.insertProduct(product);
    }

    @Override
    public List<ProductDTO> get_products(String query, String rental) {
        return productMapper.selectProducts(query, rental);
    }

    @Override
    public ProductDTO select_product_by_no(Integer productNo) {
        return productMapper.selectProductByNo(productNo);
    }

    @Override
    public void update_product(ProductDTO product) {
        productMapper.updateProduct(product);
    }

    @Override
    public void delete_product(Integer productNo) {
        productMapper.deleteProduct(productNo);
    }

//    @Override
//    public String getProfileImageBase64(String employeeId) {
//        Optional<EmployeeDTO> employee = profileRepository.findById(employeeId);
//        if (employee.isPresent() && employee.get().getProfileImage() != null) {
//            byte[] imageBytes = employee.get().getProfileImage();
//            return Base64.getEncoder().encodeToString(imageBytes);  // Blob 데이터를 Base64 문자열로 변환
//        }
//        return null;
//    }

}
