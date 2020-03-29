
package org.springframework.samples.oculusdb.administrator;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.oculusdb.model.Application;

import java.util.List;

public interface ApplicationRepository extends CrudRepository<Application, Integer> {

	@Query("select fv from User c join c.favorites fv where c.id = ?2 and fv.id = ?1")
	Application applicationOfUserById(int appId, int userId);

}
