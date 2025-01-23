package com.pedrosanz.pruebatec.infrastructure.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDTO {

    private int status;
    private String message;

}
