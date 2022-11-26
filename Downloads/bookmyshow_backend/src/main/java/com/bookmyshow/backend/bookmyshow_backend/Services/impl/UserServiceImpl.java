package com.bookmyshow.backend.bookmyshow_backend.Services.impl;

import com.bookmyshow.backend.bookmyshow_backend.DTO.UserDTO;
import com.bookmyshow.backend.bookmyshow_backend.Repository.UserRepository;
import com.bookmyshow.backend.bookmyshow_backend.Services.UserService;
import com.bookmyshow.backend.bookmyshow_backend.converter.UserConverter;
import com.bookmyshow.backend.bookmyshow_backend.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepo;

    @Override
    public void addUser(UserDTO usDto) {
        UserEntity user = UserConverter.convertDtoToEntity(usDto);

        userRepo.save(user);
    }

    @Override
    public UserDTO getUser(int id) {
        Optional<UserEntity> userEntity = userRepo.findById(id);

        return UserConverter.convertEntityToDto(userEntity);
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<UserDTO> listOfUser = new ArrayList<>();
        for(UserEntity user : userRepo.findAll()) {
            listOfUser.add(UserConverter.convertEntityToDtoByEntity(user));
        }
        return listOfUser;
    }
}
