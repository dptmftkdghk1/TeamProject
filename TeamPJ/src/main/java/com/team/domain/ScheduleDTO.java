package com.team.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleDTO {
//    private Integer scheduleNo;
//    private String scheduleTitle;
//    private String scheduleStartDate;
//    private String scheduleEndDate;
//    private String schedulePlace;
//    private String scheduleGuests;
//    private String scheduleRemarks;
    private Integer no;
    private String title;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime start;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime end;
    private String backgroundColor;
    private String text;
}
