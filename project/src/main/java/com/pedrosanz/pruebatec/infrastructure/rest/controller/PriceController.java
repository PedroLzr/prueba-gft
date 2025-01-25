package com.pedrosanz.pruebatec.infrastructure.rest.controller;

import com.pedrosanz.pruebatec.domain.port.in.PriceService;
import com.pedrosanz.pruebatec.domain.model.Price;
import com.pedrosanz.pruebatec.infrastructure.rest.api.PriceApi;
import com.pedrosanz.pruebatec.infrastructure.rest.dto.PriceRequestDTO;
import com.pedrosanz.pruebatec.infrastructure.rest.dto.PriceResponseDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PriceController implements PriceApi {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @Override
    public ResponseEntity<PriceResponseDTO> apiV1PricesGet(@Valid @RequestBody PriceRequestDTO priceRequestDTO) {
        log.info("Llamada a pricesGet (GET /api/v1/prices) con parámetros: {}", priceRequestDTO);

        Price price = priceService.getApplicablePrice(
                priceRequestDTO.getApplicationDate(),
                priceRequestDTO.getProductId(),
                priceRequestDTO.getBrandId()
        );

        PriceResponseDTO responseDTO = new PriceResponseDTO();
        responseDTO.setProductId(price.getProductId());
        responseDTO.setBrandId(price.getBrandId());
        responseDTO.setPriceList(price.getPriceList());
        responseDTO.setStartDate(price.getStartDate());
        responseDTO.setEndDate(price.getEndDate());
        responseDTO.setPrice(price.getPrice());
        responseDTO.setCurrency(price.getCurrency());

        log.debug("Respuesta enviada al cliente: {}", responseDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
