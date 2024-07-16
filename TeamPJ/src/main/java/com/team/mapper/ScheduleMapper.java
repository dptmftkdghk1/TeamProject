package com.team.mapper;

import com.team.domain.ProductDTO;
import com.team.domain.ScheduleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ScheduleMapper {
    void insertSchedule(ScheduleDTO scheduleDTO);
    List<ScheduleDTO> selectSchedules();
    void insertCalendar(ScheduleDTO scheduleDTO);
}
