
package org.springframework.samples.oculusdb.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.repositories.PlatformRepository;

public class PlatformService {

	@Autowired
	private PlatformRepository platformRepository;


	@Transactional
	public int platformCount() {
		return (int) this.platformRepository.count();
	}
}