package dev.vorstu.dto.mapper;

import dev.vorstu.dto.Rental;
import dev.vorstu.dto.User;
import dev.vorstu.entity.RentalEntity;
import dev.vorstu.entity.UserEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {RentalMapper.class,
                BusinessPersonMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
    UserEntity dtoToEntity(User dto);

    User entityToDto(UserEntity entity);

    List<User> toList(List<UserEntity> list);

    List<UserEntity> toListEntity(List<User> list);
}
