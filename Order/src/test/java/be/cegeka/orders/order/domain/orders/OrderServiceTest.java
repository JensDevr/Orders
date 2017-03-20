package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.customers.CustomerRepository;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;

/**
 * Created by jensde on 9/03/2017.
 */
public class OrderServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private OrderService orderService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void addOrder() throws Exception {
        Order order = new Order(7, "Smurfs");
        Customer customer = new Customer("Jens", "Devriendt", "Jens.", "04");

        when(customerRepository.getCustomer(8)).thenReturn(customer);
        orderService.addOrder(8,7, "Smurfs");
        assertThat(customer.getOrders()).usingFieldByFieldElementComparator().contains(order);
    }

    @Test
    public void addPreviousOrder_ShouldAddPreviousOrder() throws Exception {
        Order order = new Order(7, "Smurfs");
        Order newOrder = new Order(7, "Smurfs");
        Customer customer = new Customer("Jens", "Devriendt", "Jens.", "04");
        customer.addOrder(order);
        setField(order, "id", 8);

        when(customerRepository.getCustomer(13)).thenReturn(customer);
        orderService.addPreviousOrder(13, 8);
        assertThat(customer.getOrders()).usingFieldByFieldElementComparator().contains(order, newOrder);




    }
}