package org.jdp.structural.proxy;

//Factory to get image objects. 

import org.springframework.stereotype.Service;


@Service
public class ImageFactory {
  //We'll provide proxy to caller instead of real object

  public Image getImage(String name) {
    return new ImageProxy(name);
  }
}
