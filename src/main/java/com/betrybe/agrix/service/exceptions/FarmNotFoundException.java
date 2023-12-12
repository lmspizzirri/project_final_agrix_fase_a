package com.betrybe.agrix.service.exceptions;

/**
 * The type Farm not found exception.
 */
public class FarmNotFoundException extends RuntimeException {

  /**
   * Instantiates a new Farm not found exception.
   *
   * @param messageError the message error
   */
  public FarmNotFoundException(String messageError) {
    super(messageError);
  }
}
