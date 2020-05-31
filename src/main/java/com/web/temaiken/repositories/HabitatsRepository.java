package com.web.temaiken.repositories;

import com.web.temaiken.models.Habitat;
import org.springframework.data.repository.CrudRepository;

public interface HabitatsRepository extends CrudRepository<Habitat, Integer> {

   Habitat findFirstById(Integer id);

}