package com.team.controller;

import com.team.domain.ScheduleDTO;
import com.team.service.scheduleservice.ScheduleService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
    private static final Logger log = LoggerFactory.getLogger(ScheduleController.class);
    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/register_schedule")
    public String get_register_schedule(){
        return "schedule/calender";
    }

    @PostMapping("/register_schedule")
    public ResponseEntity<String> post_schedule(
            @RequestBody List<ScheduleDTO> scheduleDTOS){
        for(ScheduleDTO schedule : scheduleDTOS){
            scheduleService.insert_calendar(schedule);
            log.info(schedule.toString());
        }
        return ResponseEntity.ok("성공");
    }

    @GetMapping("/to-do-list")
    public void get_schedules(Model model){
        List<ScheduleDTO> schedules = scheduleService.select_schedule();
        model.addAttribute("schedules", schedules);
    }

}
