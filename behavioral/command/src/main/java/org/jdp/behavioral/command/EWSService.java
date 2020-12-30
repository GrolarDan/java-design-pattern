package org.jdp.behavioral.command;

//This class is the receiver.

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EWSService {

  //Add a new member to mailing list
  public void addMember(String contact, String contactGroup) {
    //contact exchange
    log.info("Added {} to {}", contact, contactGroup);
  }

  //Remove member from mailing list
  public void removeMember(String contact, String contactGroup) {
    //contact exchange
    log.info("Removed {} from {}", contact, contactGroup);
  }
}
