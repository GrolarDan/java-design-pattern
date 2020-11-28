package org.jdp.structural.flyweight;

//A concrete Flyweight. Instance is shared

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class SystemErrorMessage implements ErrorMessage {

  // some error message $errorCode
  private final String messageTemplate;
  
  // http://somedomain.com?code=
  private final String helpUrlBase;

  @Override
  public String getText(String code) {
    log.debug("Running getText of SystemErrorMessage");
    return messageTemplate.replace("$errorCode", code) + helpUrlBase + code;
  }

}
