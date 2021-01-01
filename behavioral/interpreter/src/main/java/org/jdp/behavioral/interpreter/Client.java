package org.jdp.behavioral.interpreter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class Client implements CommandLineRunner {

  private final ExpressionBuilder builder;
  
  public static void main(String[] args) {
    SpringApplication.run(org.jdp.behavioral.interpreter.Client.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    User user = new User("David", "USER", "ADMIN", "FINANCIAL");
    Report report = new Report("Financial cashflow", "NOT ADMIN");
    
    PermissionExpression exp = builder.build(report);
    log.info("User {} access to report {}", exp.interpret(user) ? "has" : "has no", report);
  }

}
