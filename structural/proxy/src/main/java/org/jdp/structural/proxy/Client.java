package org.jdp.structural.proxy;

import javafx.geometry.Point2D;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {

  public static void main(String[] args) {
    Image image = ImageFactory.getImage("A1.bmp");

    image.setLocation(new Point2D(10, 10));
    log.info("Image location is: {}", image.getLocation());
    log.info("rendering image now");
    image.render();
  }

}
