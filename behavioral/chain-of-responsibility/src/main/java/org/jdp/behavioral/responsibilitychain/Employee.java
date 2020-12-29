package org.jdp.behavioral.responsibilitychain;

//Abstract handler

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Employee implements LeaveApprover {

  private final String roleName;
  private final LeaveApprover nextApprover;

  @Override
  public void processRequest(LeaveApplication application) {
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