package com.thrive.userservice.service;

import com.thrive.userservice.entity.Organization;
import com.thrive.userservice.entity.dto.OrganizationDTO;
import org.springframework.http.ResponseEntity;

public interface OrganizationService {
     OrganizationDTO addOrganization(OrganizationDTO organizationDTO);

    Organization findById(Long organizationId);
}
