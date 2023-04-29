package com.daadestroyer.organizationservice.service.impl;

import com.daadestroyer.organizationservice.dto.OrganizationDto;
import com.daadestroyer.organizationservice.entity.Organization;
import com.daadestroyer.organizationservice.exceptionhandling.ResourceNotFoundException;
import com.daadestroyer.organizationservice.repository.OrganizationRepo;
import com.daadestroyer.organizationservice.service.OrganizationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepo organizationRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = this.modelMapper.map(organizationDto, Organization.class);
        Organization organizationSaved = this.organizationRepo.save(organization);
        return this.modelMapper.map(organizationSaved, OrganizationDto.class);
    }


    @Override
    public List<OrganizationDto> getAllOrganization() {
        List<OrganizationDto> organizationDtoList = this.organizationRepo.findAll().stream().map(org -> this.modelMapper.map(org, OrganizationDto.class)).collect(Collectors.toList());
        return organizationDtoList;
    }

    @Override
    public OrganizationDto getOrganization(Long id) {
        Organization organization = this.organizationRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Organization", id));
        return this.modelMapper.map(organization, OrganizationDto.class);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String code) {
        Organization byOrganizationCode = this.organizationRepo.findByOrganizationCode(code);
        if(byOrganizationCode == null){
            return null;
        }
        return this.modelMapper.map(byOrganizationCode,OrganizationDto.class);
    }
}
