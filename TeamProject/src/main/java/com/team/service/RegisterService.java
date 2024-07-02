package com.team.service;

import com.team.domain.EmployeeDTO;
import com.team.mapper.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private ServiceMapper serviceMapper;

    public void insertEmployee(EmployeeDTO employeeDTO) {
        serviceMapper.insertEmployee(employeeDTO);
    }

}
