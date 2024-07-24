package com.noticeboard.mapper;

import com.noticeboard.domain.NoticeDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoticeMapper {

    @Select("SELECT * FROM `board`")
    List<NoticeDTO> getAllNotices();

    @Select("SELECT * FROM `board` WHERE board_no = #{boardNo}")
    NoticeDTO getNoticeById(Integer boardNo);

    @Insert("INSERT INTO `board` (board_no, board_title, board_content) VALUES (NULL, #{boardTitle}, #{boardContent})")
    void insertNotice(NoticeDTO notice);

    @Update("UPDATE `board` SET `board_title` = #{boardTitle}, `board_content` = #{boardContent} WHERE `board_no` = #{boardNo}")
    void updateNotice(@Param("boardNo") Integer boardNo, @Param("notice") NoticeDTO notice);

    @Delete("DELETE FROM `board` WHERE board_no = #{boardNo}")
    void deleteNotice(Integer boardNo);
}

