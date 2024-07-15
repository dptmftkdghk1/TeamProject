package com.team.domain;

import lombok.*;
import lombok.extern.log4j.Log4j2;
import java.time.LocalDateTime;

@Log4j2
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    private Integer reservationNo;
    private String reservationName;
    private String reservationCategory;
    private EmployeeDTO reservationEmployee;
    private LocalDateTime reservationDate;
    private LocalDateTime returnDate;
    private String reservationStatus;
    private String reservationContent;
}
