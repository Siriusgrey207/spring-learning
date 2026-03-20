package kristian.springframework.spring_7_rest_mvc.services;

import kristian.springframework.spring_7_rest_mvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    Customer getCustomerById(UUID uuid);
    List<Customer> getAllCustomers();
    Customer saveNewCustomer(Customer customer);
    void updateCustomerById(UUID customerId, Customer customer);
}
