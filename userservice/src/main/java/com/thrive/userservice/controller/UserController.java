package com.thrive.userservice.controller;

import com.thrive.userservice.entity.dto.OrganizationDTO;
import com.thrive.userservice.entity.dto.UserDTO;
import com.thrive.userservice.service.OrganizationService;
import com.thrive.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    final UserService userService;
    final OrganizationService organizationService;

    public UserController(UserService userService, OrganizationService organizationService) {
        this.userService = userService;
        this.organizationService = organizationService;
    }

    @PostMapping("/add-organization")
    public ResponseEntity<OrganizationDTO> addOrganisation(@RequestBody OrganizationDTO organizationDTO) {
        OrganizationDTO organization = organizationService.addOrganization(organizationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(organization);
    }

    @PostMapping("/register-user")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        UserDTO user = userService.addUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id) {
        UserDTO userDTO = userService.findbyId(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userDTO);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserDTO>  updateUser(@PathVariable("id") Long Id, UserDTO userDTO){
        UserDTO user = userService.updateUser(Id,userDTO);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/get-all-user/{organizationid}")
    public ResponseEntity<List<UserDTO>> getAllUserOfOrganization(@PathVariable("organizationid") Long organizationId) {
        List<UserDTO> userList = userService.getAllUserOfOrganisation(organizationId);
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }
}