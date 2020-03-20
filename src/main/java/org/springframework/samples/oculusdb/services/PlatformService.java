
package org.springframework.samples.oculusdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.oculusdb.repositories.PlatformRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PlatformService {

   @Autowired
   private PlatformRepository platformRepository;

   @Transactional
   public int platformCount() {
      return (int) this.platformRepository.count();
   }

}
