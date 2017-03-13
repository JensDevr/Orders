package be.cegeka.orders.order.controllers;

import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.customers.CustomerService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jensde on 7/03/2017.
 */
public class CustomerControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerServiceMock;

    @Test
    public void addCustomer_ShouldAddCustomer() throws Exception {

        customerController.addCustomer("Jens", "Devriendt", "Jens.", "04");
        verify(customerServiceMock).addCustomer("Jens", "Devriendt", "Jens.", "04");

    }

    @Test
    public void getAllCustomers_ShouldReturnAllCustomers() throws Exception {

        List<Customer> expected = new ArrayList<>();
        Customer customer1 = new Customer("Jens", "Devriendt", "Jens.", "04");
        Customer customer2 = new Customer("Seppe", "Gielen", "Seppe.", "04");

        expected.add(customer1);
        expected.add(customer2);

        when(customerServiceMock.getAllCustomers()).thenReturn(expected);
        assertThat(customerController.getAllCustomers()).contains(customer1, customer2);

    }

    @Test
    public void getByID_ShouldReturnCustomerWithID() throws Exception {

        Customer customer1 = new Customer("Jens", "Devriendt", "Jens.", "04");

        when(customerServiceMock.getByID(8)).thenReturn(customer1);
        Customer customer = customerController.getByID(8);
        assertThat(customer).isEqualTo(customer1);

    }
}