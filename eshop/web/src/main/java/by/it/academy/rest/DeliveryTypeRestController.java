package by.it.academy.rest;

import by.it.academy.service.model.DeliveryType;
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

    @GetMapping("/api/deliveries/types")
    public ResponseEntity<List<DeliveryType>> getAllDeliveryTypes() {
        List<DeliveryType> deliveryTypes = List.of(
                new DeliveryType(1, "Self pick up in strore"),
                new DeliveryType(2, "Express post"),
                new DeliveryType(3, "Courier service")
        );
        return new ResponseEntity<>(deliveryTypes, HttpStatus.OK);
    }
}
