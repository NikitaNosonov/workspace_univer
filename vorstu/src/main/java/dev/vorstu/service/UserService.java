package dev.vorstu.service;

import dev.vorstu.dto.User;
import dev.vorstu.dto.mapper.UserMapper;
import dev.vorstu.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
