package com.team.mapper;


import com.team.domain.NoticeDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface NoticeMapper {
    @Insert("INSERT INTO `board` (no, title, content) VALUES (NULL, #{title}, #{content})")
    void insertNotice(NoticeDTO notice);

    @Update("UPDATE board` SET no = #{no}, " +
            "title = #{title}, content = #{content} " +
            "WHERE no = #{no}")
    void updateNotice(NoticeDTO notice);

    @Delete("DELETE FROM board` WHERE no = #{no}")
    void deleteNotice(NoticeDTO notice);
}
