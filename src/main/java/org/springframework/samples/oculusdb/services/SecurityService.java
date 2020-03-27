package org.springframework.samples.oculusdb.services;

import org.springframework.stereotype.Service;

@Service
public interface SecurityService {

	String findLoggedInUsername();

	void autoLogin(String username, String password);

}