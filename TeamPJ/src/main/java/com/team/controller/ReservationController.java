package com.team.controller;

import com.team.domain.ReservationDTO;
import com.team.service.reserveservice.ReserveService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservation")
@Log4j2
public class ReservationController {
    @Autowired
    ReserveService reserveService;

    @GetMapping("/reservation")
    public void get_reservation(
            @PathVariable Integer productNo,
            @PathVariable String ProductName,
            @PathVariable String ProductCategory

    ) {

    }

//    @GetMapping("/reservation/{productNo}/{productName}/{productCategory}")
//    public void get_reservation(){
//
//    }

    @PostMapping("/reservation")
    public String post_reservation(ReservationDTO reservationDTO) {
        reserveService.insertReservation(reservationDTO);
        log.info(reservationDTO);
        return "reservation/reservation";
    }
}
