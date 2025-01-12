package dev.vorstu.dto.mapper;

import dev.vorstu.dto.Admin;
import dev.vorstu.dto.BusinessPerson;
import dev.vorstu.dto.credential.Credential;
import dev.vorstu.entity.AdminEntity;
import dev.vorstu.entity.BusinessPersonEntity;
import dev.vorstu.entity.credential.CredentialEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {LocationMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BusinessPersonMapper {
    BusinessPersonEntity dtoToEntity(BusinessPerson dto);

    BusinessPerson entityToDto(BusinessPersonEntity entity);

    List<BusinessPerson> toList(List<BusinessPersonEntity> list);

    List<BusinessPersonEntity> toListEntity(List<BusinessPerson> list);
}
