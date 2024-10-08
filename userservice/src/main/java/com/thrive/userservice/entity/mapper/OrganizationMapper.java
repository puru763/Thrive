package com.thrive.userservice.entity.mapper;

import com.thrive.userservice.entity.Organization;
import com.thrive.userservice.entity.dto.OrganizationDTO;
import org.springframework.stereotype.Component;


@Component
public class OrganizationMapper {

public OrganizationDTO  entityToOrganisationDTO(Organization organization){
    OrganizationDTO organizationDTO = new OrganizationDTO();
    organizationDTO.setName(organization.getName());
    return organizationDTO;
}


public  Organization  dtoToOrganisation(OrganizationDTO organizationDTO){
    Organization organization = new Organization();
    organization.setName(organizationDTO.getName());
    return   organization;
}

}