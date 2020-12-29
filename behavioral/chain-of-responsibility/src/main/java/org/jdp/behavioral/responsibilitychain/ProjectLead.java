package org.jdp.behavioral.responsibilitychain;

//A concrete handler
public class ProjectLead extends Employee {

  public ProjectLead(LeaveApprover nextApprover) {
    super("Project Lead", nextApprover);
  }
  
  @Override
  protected boolean processLeaveApplication(LeaveApplication application) {
    if (application.getType() == LeaveApplication.Type.Sick) {
      if (application.getNoOfDays() <= 2) {
        application.approve(getApproverRole());
        return true;
      }
    }
    return false;
  }

}
