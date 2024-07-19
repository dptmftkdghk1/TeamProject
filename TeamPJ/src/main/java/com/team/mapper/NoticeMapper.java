package com.team.mapper;


import com.team.domain.NoticeDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    @Select("SELECT * FROM `board`")
    List<NoticeDTO> selectAllNotice();

    @Insert("INSERT INTO `board` (board_no, board_title, board_content) VALUES (NULL, #{boardTitle}, #{boardContent})")
    void insertNotice(NoticeDTO notice);

    @Update("UPDATE `board` SET " +
            "board_title = #{boardTitle}, board_content = #{boardContent} " +
            "WHERE board_no = #{no}")
    void updateNotice(NoticeDTO notice);

    @Delete("DELETE FROM `board` WHERE board_no = #{no}")
    void deleteNotice(Long notice);


}
