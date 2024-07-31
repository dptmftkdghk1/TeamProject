package com.noticeboard.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class NoticeDTO {
    private Integer boardNo;
    private String boardCategory;
    private String boardTitle;
    private String boardContent;
    private String boardImage;
    private String boardWriter;
    private LocalDate boardDate;
    private Integer boardViewCount;
}