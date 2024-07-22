package com.team.controller;



import com.team.domain.NoticeDTO;
import com.team.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Notice_Service")
public class NoticeBoardController {
//    @Autowired private NoticeService noticeService;

    @Autowired private NoticeMapper noticeMapper;


    @GetMapping("/notice")
    public String create_view(Model model){
        List<NoticeDTO> notices = noticeMapper.selectAllNotice();
        model.addAttribute("notices", notices);
        System.out.println(notices);
        return "notice/notice";
    }


    @GetMapping("/registration")
    private String get_registration_view(){
        return "notice/registration";
    }

    @PostMapping("/registration")
    private String post_registration_view(NoticeDTO notice){
        noticeMapper.insertNotice(notice);
        return "notice/registration";
    }
    @PutMapping("/notice/{no}")
    public String updateMember(@RequestBody NoticeDTO updateMemberRequestDTO, @PathVariable("no") Integer no) {
        noticeMapper.updateNotice(updateMemberRequestDTO);
        return "redirect:/notice/notice";
    }
    @DeleteMapping("/notice/{id}")
    public String delete(@PathVariable("id") Long No) {
        noticeMapper.deleteNotice(No);
        return "redirect:/";
    }
}