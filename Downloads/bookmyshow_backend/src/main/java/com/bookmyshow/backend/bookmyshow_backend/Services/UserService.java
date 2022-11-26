package com.bookmyshow.backend.bookmyshow_backend.Services;

import com.bookmyshow.backend.bookmyshow_backend.DTO.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void addUser(UserDTO usDto);
    UserDTO getUser(int id);

    List<UserDTO> getAllUser();
}
