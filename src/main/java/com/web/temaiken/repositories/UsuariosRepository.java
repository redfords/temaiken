package com.web.temaiken.repositories;

import com.web.temaiken.models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuariosRepository extends CrudRepository<Usuario, Integer> {

   Usuario findFirstById(Integer id);

}