package org.jdp.structural.proxy;

import javafx.geometry.Point2D;
import lombok.extern.slf4j.Slf4j;

//Our concrete class providing actual functionality
@Slf4j
public class BitmapImage implements Image {

  private Point2D location;
  private final String name;

  public BitmapImage(String filename) {
    //Loads image from file on disk
    log.info("Loaded from disk: {}", filename);
    name = filename;
  }

  @Override
  public void setLocation(Point2D point2d) {
    location = point2d;
  }

  @Override
  public Point2D getLocation() {
    return location;
  }

  @Override
  public void render() {
    //renders to screen
    log.info("Rendered {}", this.name);
  }

}
