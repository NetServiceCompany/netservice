package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.Staff;
import com.cvc.netservice.service.dto.StaffDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface StaffMapper {

    StaffDTO toStaffDTO(Staff entity);

    Staff toEntity(StaffDTO dto);
}
