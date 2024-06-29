package com.team.domain;

import lombok.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Integer employeeNo;
    private String employeeName;
    private String employeeId;
    private String employeePassword;
    private String employeeBirthDate;
    private String employeePhoneNumber;
    private String employeeEmail;
    private String employeeAddress;
    private String employeeDetailedAddress;
    private String employeeGender;
}
