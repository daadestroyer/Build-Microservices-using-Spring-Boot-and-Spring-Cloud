package com.daadestroyer.employeeservice.exceptionhandling;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private Long id;

    public ResourceNotFoundException(String resourceName, Long id) {
        super(resourceName + " with id " + id + " not found in Database");
        this.resourceName = resourceName;
        this.id = id;
    }

    public ResourceNotFoundException(String resourceName) {
        super("List of " + resourceName + " not found in Database");
        this.resourceName = resourceName;
    }
}
