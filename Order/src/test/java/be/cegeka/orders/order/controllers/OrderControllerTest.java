package be.cegeka.orders.order.controllers;

import be.cegeka.orders.order.domain.orders.OrderService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * Created by jensde on 9/03/2017.
 */
public class OrderControllerTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    @Test
    public void addOrder_ShouldAddOrder() throws Exception {

        orderController.addOrder(8,7, "Smurfs");
        verify(orderService).addOrder(8, 7, "Smurfs");
    }

    @Test
    public void addPreviousOrder_ShouldAddPreviousOrder() throws Exception {

        orderController.addPreviousOrder(8,1);
        verify(orderService).addPreviousOrder(8, 1);

    }
}