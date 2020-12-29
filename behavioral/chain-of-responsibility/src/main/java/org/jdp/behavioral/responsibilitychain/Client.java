package org.jdp.behavioral.responsibilitychain;

import java.time.LocalDate;
import lombok.extern.slf4j.Slf4j;
import static org.jdp.behavioral.responsibilitychain.LeaveApplication.Type.PTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Client implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(org.jdp.behavioral.responsibilitychain.Client.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
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

  private LeaveApprover setupApprovers() {
    Director director = new Director(null);
    Manager manager = new Manager(director);
    ProjectLead lead = new ProjectLead(manager);
    return lead;
  }

}
