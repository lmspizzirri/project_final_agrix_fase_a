package com.betrybe.agrix.service;

import com.betrybe.agrix.model.entities.Farm;
import com.betrybe.agrix.model.repositories.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Farm service.
 */
@Service
public class FarmService {

  @Autowired
  private FarmRepository farmRepository;

  /**
   * Instantiates a new Farm service.
   *
   * @param farmRepository the farm repository
   */
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  /**
   * Create farm.
   *
   * @param farm the farm
   * @return the farm
   */
  public Farm create(Farm farm) {
    return farmRepository.save(farm);
  }

}
