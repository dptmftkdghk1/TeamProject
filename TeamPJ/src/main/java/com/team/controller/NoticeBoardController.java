package com.team.controller;



import com.team.domain.NoticeDTO;
import com.team.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Notice_Service")
public class NoticeBoardController {
//    @Autowired private NoticeService noticeService;

    @Autowired private NoticeMapper noticeMapper;


    @GetMapping("/notice")
    private String create_view(){
        return "notice/notice";
    }


//    @GetMapping("/registration")
//    private String get_registration_view(){
//        return "registration";
//    }
//
//    @PostMapping("/registration")
//    private String post_registration_view(NoticeDTO notice){
//        noticeMapper.insertNotice(notice);
//        return "registration";
//    }
//    @PatchMapping("notice/")
//    public void updateMember(@RequestBody NoticeDTO updateMemberRequestDTO) {
//        noticeMapper.updateNotice(updateMemberRequestDTO);
//    }
//    @DeleteMapping("/notice/{no}")
//    public void deleteMember(@PathVariable Integer no) {
//        noticeMapper.deleteNotice(no);
//    }
}
