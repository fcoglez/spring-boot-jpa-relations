package com.springboot.jpa.repositories;

import com.springboot.jpa.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface IClientRepository extends CrudRepository<Client, Long> {

}
