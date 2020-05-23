
package org.springframework.samples.oculusdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.application.Reviews;
import org.springframework.samples.oculusdb.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Transactional
	public int reviewCount() {
		return (int) this.reviewRepository.count();
	}

	@Transactional
	public Iterable<Reviews> reviewsList() {
		return reviewRepository.findAll();
	}

}
