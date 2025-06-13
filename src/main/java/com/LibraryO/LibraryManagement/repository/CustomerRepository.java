package com.LibraryO.LibraryManagement.repository;

import com.LibraryO.LibraryManagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
