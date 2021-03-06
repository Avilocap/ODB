
package org.springframework.samples.oculusdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.application.Comments;
import org.springframework.samples.oculusdb.repositories.CommentsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CommentsService {

	@Autowired
	private CommentsRepository commentsRepository;

	@Transactional
	public int commentsCount() {
		return (int) this.commentsRepository.count();
	}

	@Transactional
	public Comments saveComment(Comments comment) {
		return commentsRepository.save(comment);
	}

	@Transactional
	public Iterable<Comments> findAllByAplicationId(int applicationId) {
		return this.commentsRepository.findAllByApplicationId(applicationId);

	}

	@Transactional
	public Optional<Comments> findCommentById(int id) {
		return this.commentsRepository.findById(id);
	}

	public void deleteCommentById(Integer id) {
		this.commentsRepository.deleteById(id);
	}

	public void deleteComment(Comments c) {
		this.commentsRepository.delete(c);
	}

}
