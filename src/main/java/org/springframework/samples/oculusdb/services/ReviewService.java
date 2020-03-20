
package org.springframework.samples.oculusdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Transactional
	public int reviewCount() {
		return (int) this.reviewRepository.count();
	}

}
