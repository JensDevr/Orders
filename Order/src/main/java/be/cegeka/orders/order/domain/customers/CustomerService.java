package be.cegeka.orders.order.domain.customers;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

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

    public List<Customer> getAllCustomers() {
        return customerRepository.getAll();
    }

    public Customer getByID(int id) {
        return customerRepository.getCustomer(id);
    }
}
