package com.team.domain;

import lombok.*;
import lombok.extern.log4j.Log4j2;

@Getter
@Setter
@Builder
@ToString(exclude = {"data","url"})
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {
    private String UUID;
    private String originalFileName;
    private String saveFileName;
    private byte[] data;
    private String url;
}