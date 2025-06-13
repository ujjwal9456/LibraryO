package com.LibraryO.LibraryManagement.repository;


import com.LibraryO.LibraryManagement.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
