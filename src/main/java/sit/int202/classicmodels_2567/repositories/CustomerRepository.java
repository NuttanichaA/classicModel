package sit.int202.classicmodels_2567.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int202.classicmodels_2567.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}