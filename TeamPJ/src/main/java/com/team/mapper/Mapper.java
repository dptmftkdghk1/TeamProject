package com.team.mapper;

import com.team.domain.EmployeeDTO;
import com.team.domain.ProductDTO;
import org.apache.ibatis.annotations.Param;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {
    void insertEmployee(EmployeeDTO employeeDTO);
    Boolean selectEmployeeIdIsAvailable(@Param("employeeId") String employeeId);

    void insertProduct(ProductDTO productDTO);

    void selectProduct(ProductDTO productDTO);
}
