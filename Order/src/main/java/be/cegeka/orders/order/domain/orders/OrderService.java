package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.CustomerRepository;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by jensde on 9/03/2017.
 */
@Named
public class OrderService {
    @Inject
    private CustomerRepository customerRepository;

    public void addOrder(int customerID, int amount, String description) {
        customerRepository.getCustomer(customerID).addOrder(new Order(amount, description));
    }

    public void addPreviousOrder(int customerID, int orderID) {
        customerRepository.getCustomer(customerID).addPreviousOrder(orderID);
    }
}
