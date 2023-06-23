package com.employeemployee.converter;
import com.employeemployee.dto.ContactDTO;
import com.employeemployee.model.FContact;
import org.springframework.stereotype.Component;

@Component
public class ContactConverter extends Convertable<FContact, ContactDTO> {
    public FContact convertToEntity(ContactDTO dto) {
        return this.copyConvertToEntity(dto,new FContact());
    }
    public ContactDTO convertToDto(FContact entity) {
        if(entity == null){
            return null;
        }
        ContactDTO dto = new ContactDTO();
        dto.setId(entity.getId());
        dto.setPhone(entity.getPhone());
        return dto;
    }

    @Override
    public FContact copyConvertToEntity(ContactDTO dto, FContact entity) {
        if(dto == null || entity == null) {
            return entity;
        }
//        entity.setId(dto.getId());
        entity.setPhone(dto.getPhone());
        return entity;
    }
}
