
package dev.vorstu.service;

import dev.vorstu.dto.User;
import dev.vorstu.dto.credential.Credential;
import dev.vorstu.dto.mapper.UserMapper;
import dev.vorstu.entity.UserEntity;
import dev.vorstu.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User create(User user) {
        return userMapper.entityToDto(
                userRepository.save(userMapper.dtoToEntity(user))
        );
    }

    public User update(User user) {
        return userMapper.entityToDto(
                userRepository.save(userMapper.dtoToEntity(user))
        );
    }

    public Long delete(Long id) {
        userRepository.deleteById(id);
        return id;
    }

    public List<User> getUsers() {
        return userMapper.toList(
                userRepository.findAll()
        );
    }

    public Optional<User> findById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity != null) {
            return Optional.of(userMapper.entityToDto(userEntity));
        } else {
            return Optional.empty();
        }
    }
}
