package com.team.mapper;

import com.team.domain.EmployeeDTO;
import com.team.domain.MemoDTO;
import com.team.domain.ProductDTO;
import com.team.domain.ReservationDTO;
import org.apache.ibatis.annotations.Param;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {
//    로그인 관련
    void insertEmployee(EmployeeDTO employeeDTO);
    Boolean selectEmployeeIdIsAvailable(@Param("employeeId") String employeeId);
    void updateEmployeePassword(String employeeId, String password);

//    제품 관련
    void insertProduct(ProductDTO productDTO);


//    메모 관련
    void insertMemo(MemoDTO memoDTO);

//  대여 관련
    void insertReservation(ReservationDTO reservationDTO);

}
