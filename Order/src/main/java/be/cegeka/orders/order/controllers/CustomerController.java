package be.cegeka.orders.order.controllers;


import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.customers.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by jensde on 7/03/2017.
 */
@RestController
public class CustomerController {
    @Inject
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.POST)
    public void addCustomer(@RequestParam(value = "firstName", required = true)String firstName,
                            @RequestParam(value = "lastName", required = true)String lastName,
                            @RequestParam(value = "email", required = true)String email,
                            @RequestParam(value = "phoneNumber", required = true)String phoneNumber){
        customerService.addCustomer(firstName, lastName, email, phoneNumber);
    }
}
