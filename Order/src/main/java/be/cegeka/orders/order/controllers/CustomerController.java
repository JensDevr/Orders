package be.cegeka.orders.order.controllers;


import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.customers.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by jensde on 7/03/2017.
 */
@RestController
@Transactional
@RequestMapping(path = "/customer")
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

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getAllCustomers(){
    return customerService.getAllCustomers();
    }


    @RequestMapping(method = RequestMethod.GET, path = "/:id")
    public Customer getByID(@PathVariable(value = "id", required = true)int id) {
        return customerService.getByID(id);
    }
}
