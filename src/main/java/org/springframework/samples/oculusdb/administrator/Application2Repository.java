package org.springframework.samples.oculusdb.administrator;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.samples.oculusdb.application.Application2;
import org.springframework.samples.oculusdb.owner.Pet;
import org.springframework.samples.oculusdb.owner.PetType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Application2Repository extends Repository<Application2, Integer> {

	void save(Application2 application2);

}
