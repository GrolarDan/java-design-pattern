package org.jdp.behavioral.responsibilitychain;

//This represents a handler in chain of responsibility
public interface LeaveApprover {
  void processRequest(LeaveApplication application);
  
  String getApproverRole();
}
