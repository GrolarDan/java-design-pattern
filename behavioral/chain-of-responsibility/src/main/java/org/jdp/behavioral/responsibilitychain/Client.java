package org.jdp.behavioral.responsibilitychain;

import java.time.LocalDate;
import static org.jdp.behavioral.responsibilitychain.LeaveApplication.Type.PTO;

public class Client {

  public static void main(String[] args) {
    LeaveApprover approver = setupApprovers();
    LeaveApplication application = LeaveApplication.getBuilder()
            .withType(PTO)
            .from(LocalDate.now())
            .to(LocalDate.now().plusDays(4))
            .build();
    
    System.out.println("Before approving:\n" + application);
    System.out.println("--------------------------------");
    approver.processRequest(application);
    System.out.println("After approving:\n" + application);
  }

  private static LeaveApprover setupApprovers() {
    Director director = new Director(null);
    Manager manager = new Manager(director);
    ProjectLead lead = new ProjectLead(manager);
    return lead;
  }
}
