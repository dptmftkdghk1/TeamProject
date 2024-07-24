package com.team.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.team.domain.ScheduleDTO;
import com.team.service.scheduleservice.ScheduleService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Controller
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/calendar")
    public void get_calender(){}

    @ResponseBody
    @GetMapping
    public List<ScheduleDTO> get_schedules(){
        List<ScheduleDTO> schedules = scheduleService.select_schedules();
        return schedules;
    }

    @PostMapping("/calendar")
    public ResponseEntity<ScheduleDTO> post_insert_schedule(
            @RequestBody ScheduleDTO schedule){
        scheduleService.insert_calendar(schedule);
        log.info(schedule.toString());
        return ResponseEntity.ok(schedule);
    }

    @GetMapping("/get_schedule/{no}")
    public ResponseEntity<ScheduleDTO> get_schedule(@PathVariable("no") Integer no){
        ScheduleDTO schedule = scheduleService.select_scheduleByNo(no);
        return ResponseEntity.ok(schedule);
    }

    @PutMapping("/update/{no}")
    public ResponseEntity<ScheduleDTO> update_schedule(
            @PathVariable("no") Integer no,
            @RequestBody ScheduleDTO schedule
    ){
        schedule.setNo(no);
        System.out.println("업데이트: " + schedule);
        scheduleService.update_schedule(schedule);
        return ResponseEntity.ok(schedule);
    }

    @DeleteMapping("/delete/{no}")
    public ResponseEntity<Void> delete_schedule(
            @PathVariable("no") Integer no
    ){
        scheduleService.delete_schedule(no);
        return ResponseEntity.ok().body(null);
    }

}
