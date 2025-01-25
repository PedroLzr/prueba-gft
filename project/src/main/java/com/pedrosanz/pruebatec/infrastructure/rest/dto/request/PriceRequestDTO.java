package com.pedrosanz.pruebatec.infrastructure.rest.dto.request;

import jakarta.validation.constraints.Positive;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Data
public class PriceRequestDTO {

    @NotNull(message = "La fecha de aplicación es obligatoria")
    private LocalDateTime applicationDate;

    @NotNull(message = "El identificador del producto es obligatorio")
    @Positive(message = "El identificador del producto debe ser mayor a 0")
    private Long productId;

    @NotNull(message = "El identificador de la marca es obligatorio")
    @Positive(message = "El identificador de la marca debe ser mayor a 0")
    private Long brandId;

}
