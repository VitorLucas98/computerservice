package com.vitorlucas.computerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitorlucas.computerservice.entities.OrderOfService;

@Repository
public interface OrderOfServiceRepository extends JpaRepository<OrderOfService, Long> {

}
