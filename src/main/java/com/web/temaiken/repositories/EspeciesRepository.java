package com.web.temaiken.repositories;

import com.web.temaiken.models.Especie;
import org.springframework.data.repository.CrudRepository;

public interface EspeciesRepository extends CrudRepository<Especie, Integer> {

   Especie findFirstById(Integer id);

}