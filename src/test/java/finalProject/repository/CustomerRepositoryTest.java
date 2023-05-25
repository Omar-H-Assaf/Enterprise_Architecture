package finalProject.repository;

import finalProject.domain.Customer;
import finalProject.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void setCustomerRepository(){
        Customer customer = new Customer("mail");
        entityManager.persist(customer);
        entityManager.flush();


        Optional<Customer> found = customerRepository.findByEmail("mail");
        assertThat(found.get().getEmailAddress(), equalTo(customer.getEmailAddress()));
        //assertNotNull(found);




    }

}
