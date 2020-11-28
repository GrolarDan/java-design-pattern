package org.jdp.structural.flyweight;

//A concrete Flyweight. Instance is shared

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SystemErrorMessage implements ErrorMessage {

  // some error message $errorCode
  private final String messageTemplate;
  
  // http://somedomain.com?code=
  private final String helpUrlBase;

  @Override
  public String getText(String code) {
    return messageTemplate.replace("$errorCode", code) + helpUrlBase + code;
  }

}
