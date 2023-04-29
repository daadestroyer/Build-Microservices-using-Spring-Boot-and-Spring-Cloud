package com.daadestroyer.organizationservice.exceptionhandling;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Builder
public class APIResponse {
    private String message;
    private String status;
}