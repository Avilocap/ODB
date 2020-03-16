
package org.springframework.samples.oculusdb.administrator;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.oculusdb.model.Application;

public interface ApplicationRepository extends CrudRepository<Application, Integer> {

}
