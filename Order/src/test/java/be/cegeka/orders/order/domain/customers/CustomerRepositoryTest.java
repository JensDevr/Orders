package be.cegeka.orders.order.domain.customers;

import be.cegeka.orders.order.OrderApplication;
import org.assertj.core.api.Assertions;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class CustomerRepositoryTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private CustomerRepository customerRepository;
    private Customer seppe, johan;

    @Before
    public void setupDatabase() {
        seppe = new Customer("Seppe", "Gielen", "Seppe.", "04");
        johan = new Customer("Johan", "Vdw", "Johan.", "04");

        entityManager.persist(seppe);
        entityManager.persist(johan);
    }

    @Test
    public void getAllShouldReturnAll() throws Exception {
        assertThat(customerRepository.getAll()).contains(seppe, johan);
    }

    @Test
    public void addCustomer_ShouldAddCustomer() throws Exception {
        Customer customer = new Customer("Jens", "Devriendt", "Jens.", "04");
        customerRepository.addCustomer(customer);
        assertThat(entityManager.find(Customer.class, customer.getId())).isEqualToComparingFieldByField(customer);

    }

    @Test
    public void getCustomer_ShouldGetCustomer() throws Exception {

        assertThat(customerRepository.getCustomer(seppe.getId())).isEqualTo(seppe);

    }

    @Test
    public void getCustomer_CustomerDoesNotExist() throws Exception {
        int id = -1;
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("No customer found for id: " + id);
        customerRepository.getCustomer(id);

    }

    @After
    public void cleanDatabase(){
        entityManager.clear();
    }
}
