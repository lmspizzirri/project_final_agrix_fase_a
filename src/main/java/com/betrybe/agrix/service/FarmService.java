package com.betrybe.agrix.service;

import com.betrybe.agrix.model.entities.Crop;
import com.betrybe.agrix.model.entities.Farm;
import com.betrybe.agrix.model.repositories.CropRepository;
import com.betrybe.agrix.model.repositories.FarmRepository;
import com.betrybe.agrix.service.exceptions.FarmNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Farm service.
 */
@Service
public class FarmService {


  private final FarmRepository farmRepository;
  private final CropRepository cropRepository;

  /**
   * Instantiates a new Farm service.
   *
   * @param farmRepository the farm repository
   */
  @Autowired
  public FarmService(FarmRepository farmRepository, CropRepository cropRepository) {
    this.farmRepository = farmRepository;
    this.cropRepository = cropRepository;
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

  /**
   * Gets all farms.
   *
   * @return the all farms
   */
  public List<Farm> getAllFarms() {
    return farmRepository.findAll();
  }

  /**
   * Gets farm by id.
   *
   * @param id the id
   * @return the farm by id
   * @throws FarmNotFoundException the farm not found exception
   */
  public Farm getFarmById(Long id) throws FarmNotFoundException {
    return farmRepository.findById(id)
        .orElseThrow(() -> new FarmNotFoundException("Fazenda não encontrada!"));
  }

  /**
   * Add crop crop.
   *
   * @param crop   the crop
   * @param farmId the farm id
   * @return the crop
   * @throws FarmNotFoundException the farm not found exception
   */
  public Crop addCrop(Crop crop, Long farmId) throws FarmNotFoundException {
    Farm farm = getFarmById(farmId);
    crop.setFarm(farm);
    return cropRepository.save(crop);
  }

}
