/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdp.behavioral.mediator;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Daniel Mašek
 */
@SpringBootApplication
public class SpringBootApplicationClient {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Application.launch(JavaFxApplicationClient.class, args);
  }
  
}
