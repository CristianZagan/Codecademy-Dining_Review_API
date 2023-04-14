package com.portfolio.codecademy.service;

import com.portfolio.codecademy.converter.UserFromDtoToEntity;
import com.portfolio.codecademy.converter.UserFromEntityToDto;
import com.portfolio.codecademy.dto.UserDto;
import com.portfolio.codecademy.model.User;
import com.portfolio.codecademy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public UserDto getUserByDisplayName(String displayName) {
        Optional<User> user = userRepository.findByDisplayName(displayName);
        return user.map(UserFromEntityToDto::convertToDto).orElse(null);
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserFromEntityToDto::convertToDto)
                .collect(Collectors.toList());
    }

    public UserDto createUser(UserDto userDto) {
        User user = UserFromDtoToEntity.convertToEntity(userDto);
        User savedUser = userRepository.save(user);
        return UserFromEntityToDto.convertToDto(savedUser);
    }

    public UserDto updateUserByDisplayName(String displayName, UserDto userDto) {
        Optional<User> existingUser = userRepository.findByDisplayName(displayName);
        if (existingUser.isPresent()) {
            User updatedUser = UserFromDtoToEntity.convertToEntity(userDto);
            updatedUser.setId(existingUser.get().getId());
            User savedUser = userRepository.save(updatedUser);
            return UserFromEntityToDto.convertToDto(savedUser);
        }
        return null;
    }

    public void deleteUserByDisplayName(String displayName) {
        Optional<User> user = userRepository.findByDisplayName(displayName);
        user.ifPresent(userRepository::delete);
    }
}
