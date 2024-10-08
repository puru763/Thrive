


package com.thrive.userservice.service;

import com.thrive.userservice.entity.dto.UserDTO;

import java.util.List;
import java.util.UUID;


public interface UserService {
    UserDTO addUser(UserDTO userDTO);

    UserDTO findbyId(Long id);

    UserDTO updateUser(Long id, UserDTO userDTO);

    List<UserDTO> getAllUserOfOrganisation(Long organizationId);
}
