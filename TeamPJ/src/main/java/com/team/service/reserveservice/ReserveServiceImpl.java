package com.team.service.reserveservice;

import com.team.domain.ProductDTO;
import com.team.domain.ReservationDTO;
import com.team.mapper.ProductMapper;
import com.team.mapper.ReserveMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ReserveServiceImpl implements ReserveService{
    @Autowired
    private ReserveMapper reserveMapper;

    @Override
    public void insertReservation(ReservationDTO reservationDTO) {
        reserveMapper.insertReservation(reservationDTO);
    }

}
