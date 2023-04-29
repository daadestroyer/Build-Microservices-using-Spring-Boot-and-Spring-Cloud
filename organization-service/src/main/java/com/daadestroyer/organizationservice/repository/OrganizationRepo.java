package com.daadestroyer.organizationservice.repository;

import com.daadestroyer.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepo extends JpaRepository<Organization,Long> {
    Organization findByOrganizationCode(String orgCode);
}
