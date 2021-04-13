package com.vitorlucas.computerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitorlucas.computerservice.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
