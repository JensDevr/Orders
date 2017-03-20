package be.cegeka.orders.order.domain.customers;

import be.cegeka.orders.order.domain.orders.Order;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.*;
import static org.springframework.test.util.ReflectionTestUtils.setField;

/**
 * Created by jensde on 16/03/2017.
 */
public class CustomerTest {
    @Test
    public void addPreviousOrder_ShouldAddPreviousOrder() throws Exception {
        Customer customer = new Customer("Jens", "Devriendt", "Jens.", "04");
        Order order1 = new Order(7, "Smurfs");
        Order order2 = new Order(8, "rolacola");
        Order order3 = new Order(7, "Smurfs");
        setField(order1, "id", 8);
        setField(order2, "id", 9);

        customer.addPreviousOrder(8);
        assertThat();

    }

}