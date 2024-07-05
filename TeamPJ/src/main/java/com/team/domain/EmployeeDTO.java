package com.team.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class EmployeeDTO {
    private Integer employeeNo;
    private String employeeCi;
    private String employeeName;
    private String employeeId;
    private String employeePassword;
    private String employeeBirthDate;
    private String employeePhoneNumber;
    private String employeeEmail;
    private String employeeAddress;
    private String employeeDetailedAddress;
    private String employeeGender;
    private String employeeDept;
    private String employeeProfileImage;

}
