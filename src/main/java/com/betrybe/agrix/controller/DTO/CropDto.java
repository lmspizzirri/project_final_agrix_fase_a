package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.model.entities.Crop;
import com.betrybe.agrix.model.entities.Farm;

/**
 * The type Crop dto.
 */
public record CropDto(Long id, String name, Double plantedArea, Long farmId) {

  /**
   * To crop crop.
   *
   * @return the crop
   */
  public Crop toCrop() {
    Farm farm = new Farm();
    farm.setId(farmId);
    return new Crop(id, name, plantedArea, farm);
  }

  /**
   * From crop crop dto.
   *
   * @param crop the crop
   * @return the crop dto
   */
  public static CropDto fromCrop(Crop crop) {
    return new CropDto(crop.getId(), crop.getName(), crop.getPlantedArea(), crop.getFarm().getId());
  }

}
