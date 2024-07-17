package com.team.mapper;

import com.team.domain.ReservationDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReserveMapper {
    //  대여 관련
    void insertReservation(ReservationDTO reservationDTO);
}
