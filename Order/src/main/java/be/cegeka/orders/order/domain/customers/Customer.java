package be.cegeka.orders.order.domain.customers;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private int id;
    @Column(name = "NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    private final String email;
    private final String phoneNumber;

    public Customer(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    public int getId() {
        return id;
    }
}
