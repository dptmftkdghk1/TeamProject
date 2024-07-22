package com.team.service.organizationservice;

import com.team.domain.organize.DepartDTO;
import com.team.domain.organize.DepartDetailDTO;
import com.team.domain.organize.RepresentDTO;

import java.util.List;

public interface OrganizationService {
    RepresentDTO select_Represent();
    List<DepartDTO> select_depart();
    List<DepartDetailDTO> select_DepartDetail();
    void Update_represent();

}
