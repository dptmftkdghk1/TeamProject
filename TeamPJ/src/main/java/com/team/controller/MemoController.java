package com.team.controller;

import com.team.domain.MemoDTO;
import com.team.service.menuservice.MemoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
@RequestMapping("/menu")

public class MemoController {

    @Autowired
    private MemoService memoService;

    @GetMapping("/memo")
    public void get_memo(){

    }

    @PostMapping("/memo")
    public String insertMemo(MemoDTO memoDTO) {
        memoService.insertMemo(memoDTO);
        log.info(memoDTO);
        return "menu/memo";
    }
}
