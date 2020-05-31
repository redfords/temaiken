package com.web.temaiken.repositories;

import com.web.temaiken.models.Zona;
import org.springframework.data.repository.CrudRepository;

public interface ZonasRepository extends CrudRepository<Zona, Integer> {

   Zona findFirstById(Integer id);

}