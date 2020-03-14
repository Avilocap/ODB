package org.springframework.samples.oculusdb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.oculusdb.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
