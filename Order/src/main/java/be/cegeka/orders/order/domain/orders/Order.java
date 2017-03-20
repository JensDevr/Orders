package be.cegeka.orders.order.domain.orders;

import javax.persistence.*;

/**
 * Created by jensde on 9/03/2017.
 */
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private int id;
    @Column(name = "AMOUNT")
    private int amount;
    @Column(name = "DESCRIPTION")
    private String description;


    public Order() {
    }

    public Order(int amount, String description) {

        this.amount = amount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Order reOrder() {
        return new Order(amount, description);
    }
}
