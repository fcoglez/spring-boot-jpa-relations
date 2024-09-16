package com.springboot.jpa.repositories;

import com.springboot.jpa.entities.Facture;
import org.springframework.data.repository.CrudRepository;

public interface IFactureRepository extends CrudRepository<Facture, Long> {

}
