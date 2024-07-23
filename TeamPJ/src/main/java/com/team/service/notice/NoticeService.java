package com.team.service.notice;


import com.team.domain.NoticeDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface NoticeService {

    // 공지사항 목록 조회
    @Transactional(readOnly = true)
    List<NoticeDTO> selectAllNotice();
    // 제목과 번호로 공지사항 검색
    @Transactional(readOnly = true)
    List<NoticeDTO> getNotices(Integer boardNo, String boardTitle);
    // 공지사항 등록 처리
    @Transactional
    void insertNotice(NoticeDTO notice);
    // 공지사항 업데이트
    @Transactional
    void updateNotice(NoticeDTO notice);
    // 공지사항 전체삭제
    @Transactional
    void deleteAllNotice(NoticeDTO notice);
    // 공지사항 선택삭제
    @Transactional
    void deleteNotice(Integer boardNo);
    // 공지사항 개수 조회
    @Transactional(readOnly = true)
    Integer countNotice(Integer boardNo);
}

