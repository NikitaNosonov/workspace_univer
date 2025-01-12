package dev.vorstu.dto.mapper;

import dev.vorstu.dto.Photo;
import dev.vorstu.dto.credential.Credential;
import dev.vorstu.entity.PhotoEntity;
import dev.vorstu.entity.credential.CredentialEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {UserMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CredentialMapper {
    CredentialEntity dtoToEntity(Credential dto);

    Credential entityToDto(CredentialEntity entity);

    List<Credential> toList(List<CredentialEntity> list);

    List<CredentialEntity> toListEntity(List<Credential> list);
}
