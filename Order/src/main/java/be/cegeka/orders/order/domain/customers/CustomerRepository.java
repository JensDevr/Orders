package be.cegeka.orders.order.domain.customers;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Customer> getAll(){
        return entityManager.createQuery("select c from Customer c" , Customer.class).getResultList();
    }

    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    public Customer getCustomer(int id) {
        try {
            return entityManager.createQuery("select c from Customer c where c.id = :id", Customer.class).setParameter("id", id).getSingleResult();
        }
        catch (NoResultException ex){
            throw new RuntimeException("No customer found for id: " + id);
        }
    }
}
