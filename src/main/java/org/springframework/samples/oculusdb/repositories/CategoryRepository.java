
package org.springframework.samples.oculusdb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.oculusdb.category.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
