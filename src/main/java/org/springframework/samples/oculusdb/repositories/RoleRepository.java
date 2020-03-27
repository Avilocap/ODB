package org.springframework.samples.oculusdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.oculusdb.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query("select c from Role c where c.name = ?1")
	Role findRoleByName(String name);

}
