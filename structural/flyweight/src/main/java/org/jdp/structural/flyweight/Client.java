package org.jdp.structural.flyweight;

public class Client {

  public static void main(String[] args) {
    SystemErrorMessage msg1 = ErrorMessageFactory.getInstance().getMessage(ErrorMessageFactory.ErrorType.GenericSystemError);
    System.out.println(msg1.getText("2005"));
  }

}
