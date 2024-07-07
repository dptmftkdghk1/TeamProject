package com.team.converter;

import com.team.domain.FileDTO;
import org.springframework.core.convert.converter.Converter;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Log4j2
public class FileConverter implements Converter<MultipartFile, List<FileDTO>> {
    @Override
    public List<FileDTO> convert(MultipartFile file) {
        return null;
    }
}
