package com.daadestroyer.departmentservice.exceptionhandling;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class ResourceAlreadyExistedException extends RuntimeException {
    private String resourceName;
    private Long id;

    public ResourceAlreadyExistedException(String resourceName, Long id) {
        super(resourceName + " with id " + id + " already exited in Database");
        this.resourceName = resourceName;
        this.id = id;
    }
}
