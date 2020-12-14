package org.jdp.structural.proxy.dynamic;

import javafx.geometry.Point2D;
import lombok.extern.slf4j.Slf4j;

import org.jdp.structural.proxy.Image;

@Slf4j
public class Client {

  public static void main(String[] args) {
    Image img = ImageFactory.getImage("A.bmp");
    img.setLocation(new Point2D(-10, 0));
    log.info("Image location is: {}", img.getLocation());
    log.info("rendering image now");
    img.render();
  }
}
