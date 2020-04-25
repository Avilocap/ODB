
package org.springframework.samples.oculusdb.administrator;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.samples.oculusdb.model.Word;

import java.util.Collection;
import java.util.List;

public interface ApplicationRepository extends CrudRepository<Application, Integer> {

	@Query("select fv from User c join c.favorites fv where c.id = ?2 and fv.id = ?1")
	Application applicationOfUserById(int appId, int userId);

	@Query("select app from Application app where app.oculusId = ?1")
	Application applicationByOculusId(String oculusId);

	@Query("select a.positiveWords from Application a where a.oculusId =?1")
	Collection<Word> getApplicationPositiveWord(String oculusID);

	@Query("select a.negativeWords from Application a where a.oculusId =?1")
	Collection<Word> getApplicationNegativeWord(String oculusID);

}
