package com.daadestroyer.organizationservice.controller;

import com.daadestroyer.organizationservice.dto.OrganizationDto;
import com.daadestroyer.organizationservice.service.impl.OrganizationServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationServiceImpl organizationServiceImpl;
    @PostMapping("/save-org")
    public ResponseEntity<?> saveOrganization(@Valid @RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganizationDto = this.organizationServiceImpl.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganizationDto, HttpStatus.OK);
    }

    @GetMapping("/get-all-org")
    public ResponseEntity<?> getAllOrg(){
        List<OrganizationDto> allOrganization = this.organizationServiceImpl.getAllOrganization();
        return new ResponseEntity<>(allOrganization,HttpStatus.OK);
    }

    @GetMapping("/get-org/{id}")
    public ResponseEntity<?> getOrg(@PathVariable Long id){
        OrganizationDto organization = this.organizationServiceImpl.getOrganization(id);
        return new ResponseEntity<>(organization,HttpStatus.OK);
    }

    @GetMapping("/get-org-by-code/{code}")
    public ResponseEntity<?> getOrgByCode(@PathVariable String code){
        OrganizationDto organizationByCode = this.organizationServiceImpl.getOrganizationByCode(code);
        if(organizationByCode == null){
            return new ResponseEntity<>("Organization with code "+code+" this not found",HttpStatus.OK);
        }
        return new ResponseEntity<>(organizationByCode,HttpStatus.OK);
    }
}
