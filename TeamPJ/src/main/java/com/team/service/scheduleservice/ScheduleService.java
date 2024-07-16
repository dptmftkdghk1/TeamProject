package com.team.service.scheduleservice;

import com.team.domain.ScheduleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ScheduleService {
    void insert_schedule(ScheduleDTO scheduleDTO);
    List<ScheduleDTO> select_schedule();
    void insert_calendar(ScheduleDTO scheduleDTO);
}
