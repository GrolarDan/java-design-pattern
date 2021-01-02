/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdp.behavioral.mediator;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Daniel Mašek
 */
@Configuration
@RequiredArgsConstructor
public class SpringUIConfiguration {
  
  private final UIMediator mediator;
  
  @Bean
  public Label getLabel() {
    return new Label(mediator);
  }
  
  @Bean
  public Slider getSlider() {
    return new Slider(mediator);
  }
  
  @Bean
  public TextBox getTextBox() {
    return new TextBox(mediator);
  }
}
