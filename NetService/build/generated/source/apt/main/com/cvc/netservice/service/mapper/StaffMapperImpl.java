package com.cvc.netservice.service.mapper;

import com.cvc.netservice.domain.Staff;
import com.cvc.netservice.service.dto.StaffDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-06-10T13:52:50+0700",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_92 (Oracle Corporation)"
)
@Component
public class StaffMapperImpl implements StaffMapper {

    @Override
    public StaffDTO toStaffDTO(Staff entity) {
        if ( entity == null ) {
            return null;
        }

        StaffDTO staffDTO = new StaffDTO();

        staffDTO.setId( entity.getId() );
        staffDTO.setFirstName( entity.getFirstName() );
        staffDTO.setLastName( entity.getLastName() );
        staffDTO.setBirthDate( entity.getBirthDate() );
        staffDTO.setAddress( entity.getAddress() );
        staffDTO.setPhone( entity.getPhone() );
        staffDTO.setPhoto( entity.getPhoto() );
        staffDTO.setStatus( entity.getStatus() );

        return staffDTO;
    }

    @Override
    public Staff toEntity(StaffDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Staff staff = new Staff();

        staff.setId( dto.getId() );
        staff.setFirstName( dto.getFirstName() );
        staff.setLastName( dto.getLastName() );
        staff.setBirthDate( dto.getBirthDate() );
        staff.setAddress( dto.getAddress() );
        staff.setPhone( dto.getPhone() );
        staff.setPhoto( dto.getPhoto() );
        staff.setStatus( dto.getStatus() );

        return staff;
    }
}
