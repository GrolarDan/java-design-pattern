package org.jdp.behavioral.interpreter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {

  public static void main(String[] args) {
    ExpressionBuilder builder = new ExpressionBuilder();
    User user = new User("David", "USER", "ADMIN", "FINANCIAL");
    Report report = new Report("Financial cashflow", "NOT ADMIN");
    
    PermissionExpression exp = builder.build(report);
    log.info("User {} access to report {}", exp.interpret(user) ? "has" : "has no", report);
  }

}
