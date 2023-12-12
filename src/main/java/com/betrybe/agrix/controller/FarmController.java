package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.FarmDto;
import com.betrybe.agrix.model.entities.Farm;
import com.betrybe.agrix.service.FarmService;
import com.betrybe.agrix.service.exceptions.FarmNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * The type Farm controller.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {

  private final FarmService farmService;

  /**
   * Instantiates a new Farm controller.
   *
   * @param farmService the farm service
   */
  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
   * Insert farm response entity.
   *
   * @param farmDto the farm dto
   * @return the response entity
   */
  @PostMapping()
  public ResponseEntity<FarmDto> insertFarm(@RequestBody FarmDto farmDto) {
    Farm newFarm = farmService.create(farmDto.toFarm());
    return new ResponseEntity<>(new FarmDto(newFarm.getId(),
        newFarm.getName(), newFarm.getSize()), HttpStatus.CREATED);
  }

  /**
   * Gets all farms.
   *
   * @return the all farms
   */
  @GetMapping
  public ResponseEntity<List<FarmDto>> getAllFarms() {
    List<Farm> allFarms = farmService.getAllFarms();
    List<FarmDto> farmDtos = allFarms.stream().map(FarmDto::fromFarm).collect(Collectors.toList());
    return ResponseEntity.ok(farmDtos);
  }

  /**
   * Gets farm by id.
   *
   * @param id the id
   * @return the farm by id
   */
  @GetMapping("/{id}")
  public ResponseEntity<?> getFarmById(@PathVariable Long id) {
    try {
      Farm farm = farmService.getFarmById(id);
      return ResponseEntity.ok(FarmDto.fromFarm(farm));
    } catch (FarmNotFoundException exception) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
  }
}
