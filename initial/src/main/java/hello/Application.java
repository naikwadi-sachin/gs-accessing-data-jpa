package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by sachin on 6/5/2015.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) throws Exception {

        //save customer
        repository.save(new Customer("Jack","Beur"));
        repository.save(new Customer("Simon","Catich"));

        //find customer
        System.out.println("customers found with findall");
        for(Customer customer : repository.findAll())
        {
            System.out.println(customer);
        }

        //fetch customer by id
        Customer customer = repository.findOne(1L);
        System.out.println("customer found with findOne(1L)");
        System.out.println(customer);

        //fetch customer by last name
        System.out.println("Customer found with findByLastName(\"Beur\")");
        for(Customer beur : repository.findByLastName("Beur"))
        System.out.println(beur);

    }
}
