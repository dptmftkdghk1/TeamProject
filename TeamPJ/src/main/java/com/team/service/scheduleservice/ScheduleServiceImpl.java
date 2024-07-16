package com.team.service.scheduleservice;

import com.team.domain.ScheduleDTO;
import com.team.mapper.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired private ScheduleMapper scheduleMapper;

    @Override
    public void insert_schedule(ScheduleDTO scheduleDTO) {
        scheduleMapper.insertSchedule(scheduleDTO);
    }

    @Override
    public List<ScheduleDTO> select_schedule() {
        return scheduleMapper.selectSchedules();
    }

    @Override
    public void insert_calendar(ScheduleDTO scheduleDTO) {
        scheduleMapper.insertCalendar(scheduleDTO);
    }
}
