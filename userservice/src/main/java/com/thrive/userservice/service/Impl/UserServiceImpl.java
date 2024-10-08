package com.thrive.userservice.service.Impl;

import com.thrive.userservice.entity.Organization;
import com.thrive.userservice.entity.User;
import com.thrive.userservice.entity.dto.OrganizationDTO;
import com.thrive.userservice.entity.dto.UserDTO;
import com.thrive.userservice.entity.mapper.UserMapper;

import com.thrive.userservice.exception.OrganizationNotFoundException;
import com.thrive.userservice.exception.UserAlreadyExistsException;
import com.thrive.userservice.exception.UserNotFoundException;
import com.thrive.userservice.repository.OrganizationRepository;
import com.thrive.userservice.repository.UserRepository;
import com.thrive.userservice.service.OrganizationService;
import com.thrive.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    final UserMapper userMapper;
    @Autowired
    final UserRepository userRepository;

    final OrganizationService organizationService;
    @Autowired
    final OrganizationRepository organizationRepository;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository, OrganizationService organizationService, OrganizationRepository organizationRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.organizationService = organizationService;
        this.organizationRepository = organizationRepository;
    }



    @Override
    public UserDTO addUser(UserDTO userDTO) {
        try {
           Optional<User> existingUser = userRepository.findByMobileNumber(userDTO.getMobileNumber());
            if (existingUser.isPresent()) {
                throw new UserAlreadyExistsException("User with mobile number " + userDTO.getMobileNumber() + " already exists.");
            }
            Optional<Organization> organizationExist = organizationRepository.findById(userDTO.getOrganizationId());
            if (organizationExist.isEmpty()) {
                throw new OrganizationNotFoundException("Organization with ID " + userDTO.getOrganizationId() + " does not exist.");
            }
            User user = userMapper.dtoToUserEntity(userDTO);
            User savedUser = userRepository.save(user);
            return userMapper.userEntityToDTO(savedUser);
        } catch (UserAlreadyExistsException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred: " + e.getMessage(), e);
        }
    }


    @Override
    public UserDTO findbyId(Long id) {
        try {
            Optional<User> existingUser = userRepository.findById(id);
            if (existingUser.isEmpty()) {
                throw new UserNotFoundException("User with ID " + id + " not found.");
            }
            return userMapper.userEntityToDTO(existingUser.get());
        } catch (UserNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred: " + e.getMessage(), e);
        }
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        try {
            Optional<User> existingUser = userRepository.findById(id);
            if (existingUser.isEmpty()) {
                throw new UserNotFoundException("User with ID " + id + " not found.");
            }
            User user = existingUser.get();
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            user.setEmail(userDTO.getEmail());
            user.setMobileNumber(userDTO.getMobileNumber());
            Organization organization = organizationService.findById(userDTO.getOrganizationId());
            user.setOrganization(organization);
            User updatedUser = userRepository.save(user);
            return userMapper.userEntityToDTO(updatedUser);
        } catch (UserNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred: " + e.getMessage(), e);
        }
    }


    @Override
    public List<UserDTO> getAllUserOfOrganisation(Long organizationId) {
        try {
            Organization organization = organizationRepository.findById(organizationId)
                    .orElseThrow(() -> new OrganizationNotFoundException("Organization with ID " + organizationId + " not found."));

            List<User> users = organization.getUsers();

            return users.stream()
                    .map(userMapper::userEntityToDTO)
                    .collect(Collectors.toList());
        } catch (OrganizationNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred: " + e.getMessage(), e);
        }
    }

}
