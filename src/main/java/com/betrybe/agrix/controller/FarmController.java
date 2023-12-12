package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.FarmDto;
import com.betrybe.agrix.model.entities.Farm;
import com.betrybe.agrix.service.FarmService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping
  public ResponseEntity<List<FarmDto>> getAllFarms() {
    List<Farm> allFarms = farmService.getAllFarms();
    List<FarmDto> farmDtos = allFarms.stream().map(FarmDto::fromFarm).collect(Collectors.toList());
    return ResponseEntity.ok(farmDtos);
  }
}
