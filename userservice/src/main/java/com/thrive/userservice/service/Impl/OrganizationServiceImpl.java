package com.thrive.userservice.service.Impl;

import com.thrive.userservice.entity.Organization;
import com.thrive.userservice.entity.dto.OrganizationDTO;
import com.thrive.userservice.entity.mapper.OrganizationMapper;
import com.thrive.userservice.repository.OrganizationRepository;
import com.thrive.userservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {


    @Autowired
    final OrganizationMapper organizationMapper;
    @Autowired
    final OrganizationRepository organizationRepository;


    public OrganizationServiceImpl(OrganizationMapper organizationMapper, OrganizationRepository organizationRepository) {
        this.organizationMapper = organizationMapper;
        this.organizationRepository = organizationRepository;
    }

    @Override
      public OrganizationDTO addOrganization(OrganizationDTO organizationDTO) {
        Organization organization = organizationMapper.dtoToOrganisation(organizationDTO);
        Organization savedOrganization = organizationRepository.save(organization);
         OrganizationDTO  response =  organizationMapper.entityToOrganisationDTO(savedOrganization);
        return response;

    }

    @Override
    public Organization findById(Long organizationId) {
        return null;
    }
}

