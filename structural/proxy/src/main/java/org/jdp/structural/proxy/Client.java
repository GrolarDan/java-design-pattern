package org.jdp.structural.proxy;

import javafx.geometry.Point2D;

public class Client {

  public static void main(String[] args) {
    Image image = ImageFactory.getImage("A1.bmp");

    image.setLocation(new Point2D(10, 10));
    System.out.println("Image location is: " + image.getLocation());
    System.out.println("rendering image now");
    image.render();
  }

}
