package com.example.demo.service;

import com.example.demo.bo.CreateUserRequest;
import com.example.demo.bo.UpdateUser;
import com.example.demo.bo.UserResponse;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserResponse createUser(CreateUserRequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(request.getName());
        userEntity.setEmail(request.getEmail());
        userEntity.setAddress(request.getAddress());
        userEntity.setPhoneNumber(request.getPhoneNumber());
        userEntity.setUsername(request.getUsername());
        userEntity.setUsername(request.getUsername().toLowerCase());// for the username to be lowercase
        userEntity.setPassword(bCryptPasswordEncoder.encode(request.getPassword())); // todo fick fixa encoding!!!

        userEntity.setRole(request.getRole());
        userEntity = userRepository.save(userEntity);
        UserResponse response = new UserResponse(userEntity.getId(), userEntity.getName());
        return response;
    }

    @Override
    public boolean updateUserService(UpdateUser request) {
        UserEntity userEntity = userRepository.findById(request.getId()).orElse(null);
        if (userEntity != null){
            userEntity.setUsername(request.getUsername());
            userEntity.setEmail(request.getEmail());
            userEntity.setPhoneNumber(request.getPhoneNumber());
            userEntity.setPassword(request.getPassword());
            userEntity= userRepository.save(userEntity);

        }else {
            return null;
        }


        return false;
    }
}
