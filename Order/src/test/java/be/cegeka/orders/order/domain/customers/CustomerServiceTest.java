package be.cegeka.orders.order.domain.customers;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Test
    public void getAllCustomers_ShouldReturnAllCustomers() throws Exception {

        Customer customer1 = new Customer("Jens", "Devriendt", "Jens.", "04");
        Customer customer2 = new Customer("Seppe", "Gielen", "Seppe.","04");
        List<Customer> expected = new ArrayList<>();
        expected.add(customer1);
        expected.add(customer2);

        when(customerRepository.getAll()).thenReturn(expected);
        assertThat(customerService.getAllCustomers()).contains(customer1, customer2);

    }
}