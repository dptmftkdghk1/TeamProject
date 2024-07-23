package com.team.controller;

import com.team.domain.organize.DepartDTO;
import com.team.domain.organize.DepartDetailDTO;
import com.team.domain.organize.RepresentDTO;
import com.team.service.organizationservice.OrganizationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/organize")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/list")
    public String get_organize_list(Model model){
        //DTO 만들고 뿌려주기
        RepresentDTO represent = organizationService.select_Represent();
//        String encodedImage = java.util.Base64.getEncoder().encodeToString(represent.getRepresentImage());

        model.addAttribute("represent", represent);
//        model.addAttribute("encodedImage", encodedImage);

        List<DepartDTO> depart = organizationService.select_depart();
        model.addAttribute("depart", depart);

        List<DepartDetailDTO> departDetail = organizationService.select_DepartDetail();
        model.addAttribute("departDetail", departDetail);

        return "/organization/organization";
    }

    @Transactional
    @PostMapping("/list")
    public ResponseEntity<String> post_reservation(
            @RequestBody Map<String, Object> jsonData

    ){
        String representContent = (String) jsonData.get("representContent");
        System.out.println("Represent Content: " + representContent);

        System.out.println(jsonData);


        organizationService.update_representContent(representContent); //컨텐츠 업데이트 완료

        List<Map<String, String>> departDataList = (List<Map<String, String>>) jsonData.get("departData");
        for (Map<String, String> departData : departDataList) {
            Integer departNo = Integer.parseInt(departData.get("departNo"));
            String departName = departData.get("departName");
            System.out.println("Depart No: " + departNo + ", Depart Name: " + departName);

             organizationService.update_departData(departNo, departName); // 예시: 부서 데이터 업데이트 로직
        }

        organizationService.delete_departDetail();
        List<Map<String, Object>> departDatasList = (List<Map<String, Object>>) jsonData.get("departDatas");
        for (Map<String, Object> departDatas : departDatasList) {
            Integer departNo = Integer.parseInt(String.valueOf(departDatas.get("departDetailNo")));
            List<String> departContentList = (List<String>) departDatas.get("departContent");
            System.out.println("Depart Detail No: " + departNo + ", Depart Content: " + departContentList);

            for(int i = 0; i < departContentList.size(); i++){
                System.out.println("No:" + departNo);
                System.out.println("Content:" + departContentList.get(i));
                String detailName = departContentList.get(i);
                if(detailName != null){
                    organizationService.insert_departDetail(departNo, detailName);
                }
            }
        }

        return ResponseEntity.ok("저장되었습니다");
    }

}
