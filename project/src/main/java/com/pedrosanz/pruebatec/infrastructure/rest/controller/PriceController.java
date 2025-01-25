package com.pedrosanz.pruebatec.infrastructure.rest.controller;

import com.pedrosanz.pruebatec.domain.port.in.PriceService;
import com.pedrosanz.pruebatec.domain.model.Price;
import com.pedrosanz.pruebatec.infrastructure.rest.dto.request.PriceRequestDTO;
import com.pedrosanz.pruebatec.infrastructure.rest.dto.response.PriceResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
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
    public ResponseEntity<?> getPrice(@RequestBody PriceRequestDTO priceRequestDTO) {
        log.info("Llamada a getPrice (GET /api/v1/prices) con parámetros: {}", priceRequestDTO);

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

        log.debug("Respuesta enviada al cliente: {}", responseDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
