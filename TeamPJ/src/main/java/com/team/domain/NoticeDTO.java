package com.team.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class NoticeDTO {
    private Integer no;
    private String category;
    private String title;
    private String content;
    private String image;
    private String writer;
    private LocalDate date;
    private Integer viewCount;
}