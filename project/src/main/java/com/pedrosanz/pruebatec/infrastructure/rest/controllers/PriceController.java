package com.pedrosanz.pruebatec.infrastructure.rest.controllers;

import com.pedrosanz.pruebatec.application.service.PriceService;
import com.pedrosanz.pruebatec.domain.model.Price;
import com.pedrosanz.pruebatec.infrastructure.rest.dto.request.PriceRequestDTO;
import com.pedrosanz.pruebatec.infrastructure.rest.dto.response.PriceResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    /**
     * Endpoint para consultar el precio aplicable.
     *
     * @param priceRequestDTO DTO de entrada con los parámetros de búsqueda
     * @return DTO de respuesta con el precio encontrado
     */
    @GetMapping
    public ResponseEntity<PriceResponseDTO> getPrice(@RequestBody PriceRequestDTO priceRequestDTO) {
        Price price = priceService.getApplicablePrice(
                priceRequestDTO.getApplicationDate(),
                priceRequestDTO.getProductId(),
                priceRequestDTO.getBrandId()
        );

        PriceResponseDTO responseDTO = new PriceResponseDTO(
                price.getProductId(),
                price.getBrandId(),
                price.getPriceList(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPrice(),
                price.getCurrency()
        );

        return ResponseEntity.ok(responseDTO);
    }
}
