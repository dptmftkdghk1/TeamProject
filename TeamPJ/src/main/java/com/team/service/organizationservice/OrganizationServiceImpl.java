package com.team.service.organizationservice;


import com.nimbusds.openid.connect.sdk.assurance.evidences.Organization;
import com.team.domain.ProductDTO;
import com.team.domain.organize.DepartDTO;
import com.team.domain.organize.DepartDetailDTO;
import com.team.domain.organize.RepresentDTO;
import com.team.mapper.OrganizationMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public RepresentDTO select_Represent() {
        return organizationMapper.selectRepresent();
    }

    @Override
    public List<DepartDTO> select_depart() {
        return organizationMapper.selectDepart();
    }

    @Override
    public List<DepartDetailDTO> select_DepartDetail() {
        return organizationMapper.selectDepartDetail();
    }

}
