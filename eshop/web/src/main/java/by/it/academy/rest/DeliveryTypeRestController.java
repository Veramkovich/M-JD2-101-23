package by.it.academy.rest;

import by.it.academy.data.model.DeliveryTypeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Open in browser: http://localhost:8080/web/deliveries/types
 */
@RestController
public class DeliveryTypeRestController {

    @GetMapping("/deliveries/types")
    public ResponseEntity<List<DeliveryTypeDto>> getAllDeliveryTypes() {
        List<DeliveryTypeDto> deliveryTypes = List.of(
                new DeliveryTypeDto(1, "Self pick up in strore"),
                new DeliveryTypeDto(2, "Express post"),
                new DeliveryTypeDto(3, "Courier service")
        );
        return new ResponseEntity<List<DeliveryTypeDto>>(deliveryTypes, HttpStatus.OK);
    }
}
