package org.jdp.behavioral.responsibilitychain;

//Abstract handler

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public abstract class Employee implements LeaveApprover {

  private final String roleName;
  private final LeaveApprover nextApprover;

  @Override
  public void processRequest(LeaveApplication application) {
    log.debug("Processing request as {}", getApproverRole());
    if (!processLeaveApplication(application) && nextApprover != null) {
      nextApprover.processRequest(application);
    }
  }

  @Override
  public String getApproverRole() {
    return roleName;
  }
  
  protected abstract boolean processLeaveApplication(LeaveApplication application);
	
}