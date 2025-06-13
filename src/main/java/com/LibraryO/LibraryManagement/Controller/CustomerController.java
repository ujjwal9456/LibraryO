package com.LibraryO.LibraryManagement.Controller;


import com.LibraryO.LibraryManagement.model.Customer;
import com.LibraryO.LibraryManagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer/")
@CrossOrigin(origins = "http://localhost:5173")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(path = "/GetCustomerById")
    public Customer GetCustomerById(@RequestParam Long id){
        return customerRepository.findById(id).orElse(null);
    }


    @PostMapping(path="/RegisterCustomer")
    public String RegisterCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return "yes";
    }
}
