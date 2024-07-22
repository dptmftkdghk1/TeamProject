package com.team.controller;

import com.team.domain.ProductDTO;
import com.team.domain.organize.DepartDTO;
import com.team.domain.organize.DepartDetailDTO;
import com.team.domain.organize.RepresentDTO;
import com.team.service.organizationservice.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/organize")
public class OrganizationController {
    @Autowired
    private OrganizationService representService;

    @GetMapping("/list")
    public String get_organize_list(Model model){
        //DTO 만들고 뿌려주기
        RepresentDTO represent = representService.select_Represent();
        model.addAttribute("represent", represent);

        List<DepartDTO> depart = representService.select_depart();
        model.addAttribute("depart", depart);

        List<DepartDetailDTO> departDetail = representService.select_DepartDetail();
        model.addAttribute("departDetail", departDetail);

        return "/organization/organization";
    }

    @PostMapping("/list")
    public ResponseEntity<String> post_reservation(
//            @RequestBody Integer item

    ){
//        Organizationservice.
//        reserveService.reservationApprove(item);
        return ResponseEntity.ok("저장되었습니다");
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
