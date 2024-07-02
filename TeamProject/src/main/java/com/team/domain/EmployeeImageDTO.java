package com.team.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeImageDTO {
    private Integer imageNo;
    private String UUID;
    private String originalName;
    private String saveName;
    private byte[] data;
}
