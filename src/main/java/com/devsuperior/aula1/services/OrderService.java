package com.devsuperior.aula1.services;

import com.devsuperior.aula1.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private ShippingService shippingService;

    public double total(Order order){
            if(order.getDiscount() > 0.0){
                return order.getBasic() - (order.getBasic() * order.getDiscount()/100) + shippingService.shipment(order);
            } else {
                return order.getBasic() + shippingService.shipment(order);
            }
    }
}
