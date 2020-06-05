
package org.springframework.samples.oculusdb.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.oculusdb.category.Category;
import org.springframework.samples.oculusdb.model.Administrator;

public interface AdministratorRepository extends CrudRepository<Administrator, Integer> {

	@Query("select c from Administrator c where c.name = ?1")
	Administrator mainAdmin(String name);

}
