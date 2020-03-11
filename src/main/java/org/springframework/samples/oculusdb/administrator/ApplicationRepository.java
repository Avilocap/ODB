package org.springframework.samples.oculusdb.administrator;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ApplicationRepository extends Repository<Application, Integer> {

	void save(Application application);

}
