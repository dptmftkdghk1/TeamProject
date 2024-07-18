package com.team.controller;

import com.team.domain.ProductDTO;
import com.team.domain.ReservationDTO;
import com.team.service.reserveservice.ReserveService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservation")
@Log4j2
public class ReservationController {
    @Autowired
    ReserveService reserveService;

    @GetMapping("/reservation")
    public String get_reservation(
            @RequestParam("productNo") Integer productNo
    ) {
        return "reservation/reservation";
    }

    @PostMapping("/reservation")
    public String post_reservation(
            @ModelAttribute @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            ReservationDTO reservationDTO
    ) {
        reserveService.insertReservation(reservationDTO);
        log.info(reservationDTO);
        return "redirect:/product/manage_product";
    }

    @GetMapping("/list")
    public String get_list(Model model, String query){
        List<ReservationDTO> reservationList = reserveService.selectReservations(query);

        System.out.println(reservationList);

        model.addAttribute("reservationList", reservationList);
        return "/reservation/reservation_list";
    }

    @GetMapping("/check/{reservationNo}")
    public String get_check(
            @PathVariable("reservationNo") Integer reservationNo,
            Model model
    ) {

        ReservationDTO reservation = reserveService.select_reservation_by_no(reservationNo);
        model.addAttribute("reservation", reservation);

        return "/reservation/reservation_check";
    }

    @PostMapping("/list")
    public ResponseEntity<String> post_update_list(
            @RequestBody ReservationDTO item,
            ReservationDTO reservationDTO
    ){
        try{
            reserveService.reservationApprove(item.getReservationNo());
            return ResponseEntity.ok("Reservation approved successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR occurred while approving reservation");
        }
//        reservationDTO.setProductNo(productNo);
//        productService.update_product(product);
//        return "redirect:/product/manage_product";
    }

//    @DeleteMapping("/list")
//    public void post_delete_list(
//            ReservationDTO reservationDTO
//    ){
//        for(ProductDTO product : products){
//            productService.delete_product(product.getProductNo());
//        }
//    }

}
