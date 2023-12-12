package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.model.entities.Farm;

/**
 * The type Farm dto.
 */
public record FarmDto(Long id, String name, double size) {

  /**
   * To farm farm.
   *
   * @return the farm
   */
  public Farm toFarm() {
    return new Farm(id, name, size);
  }

  public static FarmDto fromFarm(Farm farm) {
    return new FarmDto(farm.getId(), farm.getName(), farm.getSize());
  }
}
