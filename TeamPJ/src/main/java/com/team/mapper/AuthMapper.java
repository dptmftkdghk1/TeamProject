package com.team.mapper;

import com.team.domain.EmployeeDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {
    void insertEmployee(EmployeeDTO employeeDTO);

}
