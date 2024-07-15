package com.team.service.menuservice;

import com.team.domain.MemoDTO;
import com.team.mapper.Mapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MemoService {
    @Autowired
    private Mapper mapper;

    public void insertMemo(MemoDTO memoDTO) {
        mapper.insertMemo(memoDTO);
    }
}
