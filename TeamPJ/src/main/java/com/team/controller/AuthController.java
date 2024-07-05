package com.team.controller;

import com.team.domain.EmployeeDTO;
import com.team.service.AuthService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Log4j2
@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public void get_login(){

    }
    @GetMapping("/register")
    public void get_register(){

    }

    @PostMapping("/register")
    public String post_employee_register(@RequestParam("impUid") String impUid, EmployeeDTO employeeDTO, RedirectAttributes redirectAttributes){
        log.info("impuid" + impUid);
        log.info("employeeDTO" + employeeDTO);
        boolean result = authService.insertEmployee(impUid, employeeDTO);
        if(result){
            return "redirect:/auth/login";
        }
        redirectAttributes.addFlashAttribute("certErrorMessage","본인인증안됨");
        return "redirect:/auth/register";
    }
}
