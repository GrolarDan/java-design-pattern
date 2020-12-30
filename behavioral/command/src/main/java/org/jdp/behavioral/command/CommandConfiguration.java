/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jdp.behavioral.command;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Daniel Mašek
 */
@Configuration
@RequiredArgsConstructor
public class CommandConfiguration {

  private final EWSService service;
  
  @Bean
  @Scope(value = "prototype")
  AddMemberCommand getAddMemeberCommand(String emailAddress, String mailingList) {
    return new AddMemberCommand(emailAddress, mailingList, service);
  }
}
