package com.team.domain.organize;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RepresentDTO {
    private Integer representNo;
    private String representContent;
    private byte[] representImage;
}
