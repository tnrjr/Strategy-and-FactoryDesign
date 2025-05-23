package br.com.tary.strategyfactory.example.strategy;

import br.com.tary.strategyfactory.example.dto.ProductDiscountResponse;
import br.com.tary.strategyfactory.example.model.ProductEntity;

public interface DiscountStrategy {

    ProductDiscountResponse calcularDesconto(ProductEntity produto);
    Integer getLevelDiscount();

}
