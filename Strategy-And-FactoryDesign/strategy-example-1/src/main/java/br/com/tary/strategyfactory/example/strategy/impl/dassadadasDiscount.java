package br.com.tary.strategyfactory.example.strategy.impl;

import br.com.tary.strategyfactory.example.dto.ProductDiscountResponse;
import br.com.tary.strategyfactory.example.model.ProductEntity;
import br.com.tary.strategyfactory.example.strategy.DiscountStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class dassadadasDiscount implements DiscountStrategy {

    @Override
    public ProductDiscountResponse calcularDesconto(ProductEntity product) {
        BigDecimal discount = BigDecimal.ZERO;

        // Outras regras e validações...
        if(product.getMinClientLevelForDiscount() <= 1 && product.getPrice().compareTo(new BigDecimal("2000")) > 0){
            discount = product.getPrice().multiply(new BigDecimal("0.1"));
        }

        return ProductDiscountResponse.builder()
                .productName(product.getName())
                .priceWithoutDiscount(product.getPrice())
                .priceWithDiscount(product.getPrice().subtract(discount))
                .discountQuantity(discount)
                .build();
    }

    @Override
    public Integer getLevelDiscount() {
        return 5;
    }

}
