package com.thrive.userservice.entity.dto;

import com.thrive.userservice.entity.Organization;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
public class UserDTO {
    private String username;
    private String password;
    private String email;
    private String mobileNumber;
    private Long organizationId;


}
