package com.daadestroyer.organizationservice.service;

import com.daadestroyer.organizationservice.dto.OrganizationDto;

import java.util.List;

public interface OrganizationService {
    public OrganizationDto saveOrganization(OrganizationDto organizationDto);

    public List<OrganizationDto> getAllOrganization();

    public OrganizationDto getOrganization(Long id);

    public OrganizationDto getOrganizationByCode(String code);
}
