package com.team.controller;

import com.team.domain.ReservationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/organize")
public class OrganizationController {
    @GetMapping("/list")
    public String get_organize_list(Model model){
        return "/organization/organization";
    }
//    @GetMapping("/list")
//    public String get_list(Model model, String query){
//        List<ReservationDTO> reservationList = reserveService.selectReservations(query);
//
//        System.out.println(reservationList);
//
//        model.addAttribute("reservationList", reservationList);
//        return "/reservation/reservation_list";
//    }
}
