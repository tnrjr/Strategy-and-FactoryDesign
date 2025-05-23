package br.com.tary.strategyfactory.example.controller;

import br.com.tary.strategyfactory.example.dto.ProductDiscountResponse;
import br.com.tary.strategyfactory.example.service.DiscountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/discount")
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping(value = "/{productId }/{customerLevel }", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDiscountResponse> getProductDiscount(@PathVariable("productId ") Integer productId ,
                                                                      @PathVariable("customerLevel ") Integer customerLevel ) throws Exception {
        return new ResponseEntity<>(discountService.getProductDiscount(productId , customerLevel ), HttpStatus.OK);
    }
}
