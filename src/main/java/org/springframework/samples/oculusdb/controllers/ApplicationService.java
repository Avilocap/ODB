
package org.springframework.samples.oculusdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.administrator.ApplicationRepository;
import org.springframework.samples.oculusdb.model.Application;
import org.springframework.transaction.annotation.Transactional;

public class ApplicationService {

	@Autowired
	private ApplicationRepository applicationRepository;


	@Transactional
	public int applicationCount() {
		return (int) this.applicationRepository.count();
	}

	@Transactional
	public Iterable<Application> findAll() {
		return this.applicationRepository.findAll();
	}

}
