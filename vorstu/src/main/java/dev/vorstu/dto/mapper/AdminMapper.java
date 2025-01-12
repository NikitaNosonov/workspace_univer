package dev.vorstu.dto.mapper;

import dev.vorstu.dto.Admin;
import dev.vorstu.dto.BusinessPerson;
import dev.vorstu.entity.AdminEntity;
import dev.vorstu.entity.BusinessPersonEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {CredentialMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AdminMapper {
    AdminEntity dtoToEntity(Admin dto);

    Admin entityToDto(AdminEntity entity);

    List<Admin> toList(List<AdminEntity> list);

    List<AdminEntity> toListEntity(List<Admin> list);
}
