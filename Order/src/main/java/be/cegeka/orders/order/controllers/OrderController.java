package be.cegeka.orders.order.controllers;

import be.cegeka.orders.order.domain.orders.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by jensde on 9/03/2017.
 */
@RestController
public class OrderController {

    @Inject
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public void addOrder(@RequestParam(value = "customerID")int customerID,
                         @RequestParam(value = "amount")int amount,
                         @RequestParam(value = "description")String description){
        orderService.addOrder(customerID, amount, description);
    }
}
