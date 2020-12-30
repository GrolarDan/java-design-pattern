package org.jdp.behavioral.command;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class Client implements CommandLineRunner {

  private final ApplicationContext context;
  private final MailTasksRunner runner;
  
  public static void main(String[] args) throws InterruptedException {
    SpringApplication.run(org.jdp.behavioral.command.Client.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    runner.start();
    
    var c1 = context.getBean(AddMemberCommand.class, "a@a.com", "spam");
    runner.addCommand(c1);

    var c2 = context.getBean(AddMemberCommand.class, "b@b.com", "spam");
    runner.addCommand(c2);

    runner.shutdown();
  }

}
