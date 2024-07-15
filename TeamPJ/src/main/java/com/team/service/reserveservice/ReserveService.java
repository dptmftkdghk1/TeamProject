package com.team.service.reserveservice;

import com.team.domain.ReservationDTO;
import com.team.mapper.Mapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ReserveService {
    @Autowired
    private Mapper mapper;

    public void insertReservation(ReservationDTO reservationDTO) {
        mapper.insertReservation(reservationDTO);
    }
}
