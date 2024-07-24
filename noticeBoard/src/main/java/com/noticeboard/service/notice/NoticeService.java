package com.noticeboard.service.notice;

import com.noticeboard.domain.NoticeDTO;
import com.noticeboard.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    public List<NoticeDTO> getAllNotices() {
        return noticeMapper.getAllNotices();
    }

    public NoticeDTO getNoticeById(Integer boardNo) {
        return noticeMapper.getNoticeById(boardNo);
    }

    public void addNotice(NoticeDTO notice) {
        noticeMapper.insertNotice(notice);
    }

    public void updateNotice(Integer boardNo, NoticeDTO notice) {
        noticeMapper.updateNotice(boardNo, notice);
    }

    public void deleteNotice(Integer boardNo) {
        noticeMapper.deleteNotice(boardNo);
    }

    public void deleteNotices(List<Integer> boardNo) {
        Iterable<? extends Integer> boardNos;
        for (Integer boardNo : boardNos) {
            noticeMapper.deleteNotice(boardNo);
        }
    }
}


