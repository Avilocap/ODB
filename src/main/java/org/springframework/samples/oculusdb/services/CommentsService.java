
package org.springframework.samples.oculusdb.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.repositories.CommentsRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {

	@Autowired
	private CommentsRepository commentsRepository;


	@Transactional
	public int commentsCount() {
		return (int) this.commentsRepository.count();
	}
}
