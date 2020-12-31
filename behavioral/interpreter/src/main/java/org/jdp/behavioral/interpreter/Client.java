package org.jdp.behavioral.interpreter;

public class Client {

  public static void main(String[] args) {
    ExpressionBuilder builder = new ExpressionBuilder();
    User user = new User("David", "USER", "ADMIN");
    Report report = new Report("Financial cashflow", "FINANCIAL OR ADMIN");
    
    PermissionExpression exp = builder.build(report);
    System.out.println("User has access to report: " + exp.interpret(user));
  }

}
