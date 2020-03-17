
package org.springframework.samples.oculusdb.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.repositories.ReviewRepository;

public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;


	@Transactional
	public int reviewCount() {
		return (int) this.reviewRepository.count();
	}

}
