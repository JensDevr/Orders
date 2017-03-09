package be.cegeka.orders.order.domain.orders;

/**
 * Created by jensde on 9/03/2017.
 */
public class Order {
    private int amount;
    private String description;

    public Order(int amount, String description) {

        this.amount = amount;
        this.description = description;
    }
}
