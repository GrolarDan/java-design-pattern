package org.jdp.behavioral.responsibilitychain;

//Abstract handler
public abstract class Employee implements LeaveApprover {

  private final String roleName;
  private final LeaveApprover nextApprover;

  public Employee(String roleName, LeaveApprover nextApprover) {
    this.roleName = roleName;
    this.nextApprover = nextApprover;
  }

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