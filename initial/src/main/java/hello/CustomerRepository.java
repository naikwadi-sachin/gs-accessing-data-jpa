package hello;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sachin on 6/5/2015.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long>{
    List<Customer> findByLastName(String lastName);
}
