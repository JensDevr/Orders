package be.cegeka.orders.order.controllers;

import be.cegeka.orders.order.domain.customers.CustomerService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
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
    private CustomerService customerService;

    @Test
    public void addCustomer_ShouldAddCustomer() throws Exception {

        customerController.addCustomer("Jens", "Devriendt", "Jens.", "04");
        verify(customerService).addCustomer("Jens", "Devriendt", "Jens.", "04");

    }
}