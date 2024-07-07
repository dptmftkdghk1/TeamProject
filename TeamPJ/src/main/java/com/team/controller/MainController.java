package com.team.controller;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class MainController {
    // index 페이지를 불러옴
    @GetMapping("/main/index")
    public void get_index(){

    }
}
