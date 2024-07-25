//package com.noticeboard.service.notice;
//
//import com.noticeboard.domain.NoticeDTO;
//import com.noticeboard.mapper.NoticeMapper;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Log4j2
//@Service
//public class NoticeServiceImpl implements NoticeService {
//    private final NoticeMapper noticeMapper;
//
//    @Autowired
//    public NoticeServiceImpl(NoticeMapper noticeMapper) {
//        this.noticeMapper = noticeMapper;
//    }
//
//
//
//    // 공지사항 목록 조회
//    @Transactional(readOnly = true)
//    @Override
//    public List selectAllNotice() {
//        log.info("selectAllNotice");
//        return noticeMapper.selectAllNotice();
//    }
//    // 제목과 번호로 공지사항 검색
//    @Transactional(readOnly = true)
//    @Override
//    public List getNotices(Integer boardNo, String boardTitle) {
//        log.info("getNotices");
//        return noticeMapper.getNoticesByTitleNo(boardNo, boardTitle);
//    }
//
//    // 공지사항 등록 처리
//    @Transactional
//    @Override
//    public void insertNotice(NoticeDTO notice) {
//        log.info("insertNotice");
//        noticeMapper.insertNotice(notice);
//    }
//
//    // 공지사항 업데이트
//    @Transactional
//    @Override
//    public void updateNotice(NoticeDTO notice) {
//        log.info("updateNotice");
//        noticeMapper.updateNotice(notice);
//    }
//
//    // 공지사항 삭제
//    @Transactional
//    @Override
//    public void deleteNotice(Integer boardNo) {
//        log.info("deleteNotice");
//        noticeMapper.deleteNotice(boardNo);
//    }
//
//    // 공지사항 개수 조회
//    @Transactional(readOnly = true)
//    @Override
//    public Integer countNotice(Integer boardNo) {
//        log.info("countNotice");
//        Integer count = noticeMapper.countNotice(boardNo);
//        System.out.println("공지사항 번호: " + boardNo + ", 개수: " + count);
//        return count;
//    }
//}

