package com.noticeboard.controller;

import com.noticeboard.domain.NoticeDTO;
import com.noticeboard.service.notice.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeBoardController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping
    public List<NoticeDTO> getAllNotices() {
        return noticeService.getAllNotices();
    }

    @GetMapping("/{id}")
    public NoticeDTO getNotice(@PathVariable int id) {
        return noticeService.getNoticeById(id);
    }

    @PostMapping
    public ResponseEntity<Void> addNotice(@RequestBody NoticeDTO notice) {
        noticeService.addNotice(notice);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateNotice(@PathVariable Integer boardNo, @RequestBody NoticeDTO notice) {
        noticeService.updateNotice(boardNo, notice);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Integer boardNo) {
        noticeService.deleteNotice(boardNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteNotices(@RequestBody List<Integer> boardNo) {
        noticeService.deleteNotices(boardNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

