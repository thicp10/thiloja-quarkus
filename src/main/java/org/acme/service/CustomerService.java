package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.CustomerDTO;
import org.acme.entity.CustomerEntity;
import org.acme.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CustomerService {
    @Inject // serve para informar qual objeto queremos injetar dento da nossa classe
    private CustomerRepository customerRepository;

    public List<CustomerDTO> findAllCustomer() {

         List<CustomerDTO> customers = new ArrayList<>();

         customerRepository.findAll().stream().forEach(item->{
           customers.add(mapCustomerEntityToDTO(item));
        });

         return customers;
    }

    public void createNewCustomer(CustomerDTO customerDTO){
        customerRepository.persist(mapCustomerEntityToDTO(customerDTO));
    }

    public void  changeCustomer(Long id,CustomerDTO customerDTO){
           CustomerEntity customer =  customerRepository.findById(id);

           customer.setName(customerDTO.getName());
           customer.setAddress(customerDTO.getAddress());
           customer.setPhone(customerDTO.getPhone());
           customer.setEmail(customerDTO.getEmail());
           customer.setAge(customerDTO.getAge());

           customerRepository.persist(customer);
    }
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

    private CustomerEntity mapCustomerEntityToDTO(CustomerDTO customer){

        CustomerEntity customerDTO = new CustomerEntity();

        customerDTO.setAddress(customer.getAddress());
        customerDTO.setAge(customer.getAge());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setName(customer.getName());
        customerDTO.setAddress(customer.getAddress());

        return customerDTO;
    }

    private CustomerEntity  mapCustomerEntityToEntity(CustomerDTO customer){

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setAddress(customer.getAddress());
        customerEntity.setAge(customer.getAge());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setName(customer.getName());
        customerEntity.setAddress(customer.getAddress());

        return customerEntity;
    }

}
