package be.cegeka.orders.order.domain.customers;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;

/**
 * Created by jensde on 7/03/2017.
 */
public class CustomerServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void addCustomer_ShouldAddCustomer() throws Exception {
        Customer customer = new Customer("Jens", "Devriendt", "Jens.", "04");

        customerService.addCustomer("Jens", "Devriendt", "Jens.", "04");
        verify(customerRepository).addCustomer(refEq(customer));

    }
}