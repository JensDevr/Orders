package be.cegeka.orders.order.domain.customers;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by jensde on 7/03/2017.
 */
@Named
public class CustomerService {
    @Inject
    private CustomerRepository customerRepository;

    public void addCustomer(String firstName, String lastName, String email, String phoneNumber) {
        customerRepository.addCustomer(new Customer(firstName, lastName, email, phoneNumber));
    }
}
