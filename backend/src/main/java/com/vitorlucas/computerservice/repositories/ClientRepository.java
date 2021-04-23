package com.vitorlucas.computerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitorlucas.computerservice.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
