package org.jdp.behavioral.responsibilitychain;

import java.time.LocalDate;
import lombok.extern.slf4j.Slf4j;
import static org.jdp.behavioral.responsibilitychain.LeaveApplication.Type.PTO;

@Slf4j
public class Client {

  public static void main(String[] args) {
    System.out.println(System.getProperty("org.slf4j.simpleLogger.defaultLogLevel"));
    LeaveApprover approver = setupApprovers();
    var application = LeaveApplication.builder()
            .type(PTO)
            .from(LocalDate.now())
            .to(LocalDate.now().plusDays(4))
            .build();
    
    log.info("{}", application);
    approver.processRequest(application);
    log.info("{}", application);
  }

  private static LeaveApprover setupApprovers() {
    Director director = new Director(null);
    Manager manager = new Manager(director);
    ProjectLead lead = new ProjectLead(manager);
    return lead;
  }
}
