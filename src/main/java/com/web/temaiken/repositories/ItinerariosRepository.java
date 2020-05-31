package com.web.temaiken.repositories;

import com.web.temaiken.models.Itinerario;
import org.springframework.data.repository.CrudRepository;

public interface ItinerariosRepository extends CrudRepository<Itinerario, Integer> {

   Itinerario findFirstById(Integer id);

}