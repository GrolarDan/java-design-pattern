package org.jdp.structural.flyweight;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {

  public static void main(String[] args) {
    SystemErrorMessage msg1 = ErrorMessageFactory.getInstance().getMessage(ErrorMessageFactory.ErrorType.GenericSystemError);
    log.info(msg1.getText("2006"));
  }

}