package com.thrive.userservice.entity.mapper;

import com.thrive.userservice.entity.Organization;
import com.thrive.userservice.entity.User;
import com.thrive.userservice.entity.dto.UserDTO;
import com.thrive.userservice.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private OrganizationRepository organizationRepository;

    public UserDTO userEntityToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setMobileNumber(user.getMobileNumber());
        if (user.getOrganization() != null) {
            userDTO.setOrganizationId(user.getOrganization().getOrganizationId());
        }
        return userDTO;
    }

    public User dtoToUserEntity(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setMobileNumber(userDTO.getMobileNumber());

        if (userDTO.getOrganizationId() != null) {
            Organization organization = organizationRepository.findById(userDTO.getOrganizationId())
                    .orElseThrow(() -> new RuntimeException("Organization not found with ID: " + userDTO.getOrganizationId()));
            user.setOrganization(organization);
        }
        return user;
    }
}