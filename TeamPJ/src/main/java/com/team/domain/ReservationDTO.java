package com.team.domain;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Log4j2
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
// private Boolean enableReserve;
public class ReservationDTO {
    private Integer reservationNo;
    private ProductDTO reservationName;
    private ProductDTO reservationCategory;
    private EmployeeDTO reservationEmployee;
    private LocalDateTime reservationDate;
    private LocalDateTime returnDate;
    private Boolean reservationStatus;
    private String reservationContent;
}
