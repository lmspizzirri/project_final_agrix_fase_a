package com.betrybe.agrix.service.exceptions;

/**
 * The type Crop not found exception.
 */
public class CropNotFoundException extends RuntimeException {

  /**
   * Instantiates a new Crop not found exception.
   *
   * @param messageError the message error
   */
  public CropNotFoundException(String messageError) {
    super(messageError);
  }

}
