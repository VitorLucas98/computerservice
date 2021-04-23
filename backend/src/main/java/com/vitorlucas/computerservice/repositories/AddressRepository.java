package com.vitorlucas.computerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitorlucas.computerservice.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
