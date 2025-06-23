package com.devsuperior.aula1.services;

import com.devsuperior.aula1.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private ShippingService shippingService;

    public double total(Order order){
            double discountedPrice = order.getBasic() * (1 - order.getDiscount()/100.0);
            return discountedPrice + shippingService.shipment(order);
    }
}
