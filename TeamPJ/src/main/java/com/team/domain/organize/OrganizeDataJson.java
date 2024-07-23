package com.team.domain.organize;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrganizeDataJson {
    private String representContent;
    private List<DepartDTO> departData;
    private List<DepartDetailDTO> departDatas;
}
