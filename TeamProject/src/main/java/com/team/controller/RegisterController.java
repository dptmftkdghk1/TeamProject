package com.team.controller;

import com.team.domain.EmployeeDTO;
import com.team.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @GetMapping("/main")
    public String main() {
        return "main";
    }
    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String register
    (
            EmployeeDTO employeeDTO,
            @RequestParam("prefix") String prefix,
            @RequestParam("infix") String infix,
            @RequestParam("postfix") String postfix,
            @RequestParam("emailFirst") String emailFirst,
            @RequestParam("emailSecond") String emailSecond
    ) {

        System.out.println(employeeDTO);
        String fullNumber = prefix + "-" + infix + "-" + postfix;
        System.out.println(fullNumber);
        employeeDTO.setEmployeePhoneNumber(fullNumber);

        String fullEmail = emailFirst + "@" + emailSecond;
        System.out.println(fullEmail);
        employeeDTO.setEmployeeEmail(fullEmail);

        registerService.insertEmployee(employeeDTO);

        return "register";
    }


}
