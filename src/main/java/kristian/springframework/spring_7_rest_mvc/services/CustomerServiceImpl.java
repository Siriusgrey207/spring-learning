package kristian.springframework.spring_7_rest_mvc.services;


import kristian.springframework.spring_7_rest_mvc.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    private final Map<UUID, Customer> customerMap;

    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();

        Customer customer1 = Customer.builder()
                .id(UUID.randomUUID())
                .name("Velislav")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .id(UUID.randomUUID())
                .name("Kristian")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer customer3 = Customer.builder()
                .id(UUID.randomUUID())
                .name("Kiko")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
        customerMap.put(customer3.getId(), customer3);
    }


    @Override
    public Customer getCustomerById(UUID id) {
        return customerMap.get(id);
    }


    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }


    @Override
    public Customer saveNewCustomer(Customer customer) {
        final Customer savedCustomer = Customer
                .builder()
                .id(UUID.randomUUID())
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .version(1)
                .name(customer.getName())
                .build();

        customerMap.put(savedCustomer.getId(), savedCustomer);
        return savedCustomer;
    }


    @Override
    public void updateCustomerById(UUID customerId, Customer customer) {
        Customer existingCustomer = customerMap.get(customerId);
        existingCustomer.setName(customer.getName());
        existingCustomer.setLastModifiedDate(LocalDateTime.now());
    }
}
