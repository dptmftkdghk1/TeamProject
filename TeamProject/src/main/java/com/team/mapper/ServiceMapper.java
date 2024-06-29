package com.team.mapper;


import com.team.domain.EmployeeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ServiceMapper {

    void insertEmployee(EmployeeDTO employeeDTO);
}
