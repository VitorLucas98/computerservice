package com.vitorlucas.computerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitorlucas.computerservice.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
