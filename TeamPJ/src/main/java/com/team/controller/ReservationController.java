package com.team.controller;

import com.team.domain.ProductDTO;
import com.team.domain.ReservationDTO;
import com.team.service.reserveservice.ReserveService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservation")
@Log4j2
public class ReservationController {
    @Autowired
    ReserveService reserveService;

//    @GetMapping("/{productNo}/{productName}/{productCategory}")
//    public String get_reservation(
//            @PathVariable("productNo") Integer productNo,
//            @PathVariable("productName") Integer productName,
//            @PathVariable("productCategory") Integer productCategory
//    ){
////        ProductDTO product = productService.select_product_by_no(productNo);
////        model.addAttribute("product", product);
//        return "reservation/reservation";
//    }


    @GetMapping("/reservation")
    public String get_reservation(
            @RequestParam("productNo") Integer productNo,
            @RequestParam("productName") String productName,
            @RequestParam("productCategory") String productCategory
    ) {
        return "reservation/reservation";
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
