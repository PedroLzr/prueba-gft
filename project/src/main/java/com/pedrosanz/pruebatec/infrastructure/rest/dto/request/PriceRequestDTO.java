package com.pedrosanz.pruebatec.infrastructure.rest.dto.request;

import lombok.Data;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Data
public class PriceRequestDTO {

    @NotNull(message = "La fecha de aplicación es obligatoria")
    private LocalDateTime applicationDate;

    @NotNull(message = "El identificador del producto es obligatorio")
    private Long productId;

    @NotNull(message = "El identificador de la marca es obligatorio")
    private Long brandId;

}
