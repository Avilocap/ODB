
package org.springframework.samples.oculusdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.repositories.CommentsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CommentsService {

   @Autowired
   private CommentsRepository commentsRepository;

   @Transactional
   public int commentsCount() {
      return (int) this.commentsRepository.count();
	}

}
