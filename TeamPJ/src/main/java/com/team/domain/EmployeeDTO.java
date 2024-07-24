package com.team.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp = "(010|011|017) - [0-9]-[3,4]-[0-9]{4}")
    private String employeePhoneNumber;
    @Email
    private String employeeEmail;
    private String employeeAddress;
    private String employeeDetailedAddress;
    private String employeeGender;
    private String employeeDept;
    private String employeeProfileImage;

}
