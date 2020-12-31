package org.jdp.behavioral.interpreter;

import java.util.Stack;
import java.util.StringTokenizer;

//Parses & builds abstract syntax tree
public class ExpressionBuilder {

  private final Stack<PermissionExpression> permissions = new Stack<>();

  private final Stack<String> operators = new Stack<>();

  public PermissionExpression build(Report report) {
    parse(report.getPermission());
    buildExpressions();
    if (permissions.size() > 1 || !operators.isEmpty()) {
      System.out.println("ERROR!");
    }
    return permissions.pop();
  }

  private void parse(String permission) {
    StringTokenizer tokenizer = new StringTokenizer(permission.toLowerCase());
    while (tokenizer.hasMoreTokens()) {
      String token;
      switch ((token = tokenizer.nextToken())) {
        case "and":
          operators.push("and");
          break;
        case "not":
          operators.push("not");
          break;
        case "or":
          operators.push("or");
          break;
        default:
          permissions.push(new Permission(token));
          break;
      }
    }
  }

  private void buildExpressions() {
    while (!operators.isEmpty()) {
      String operator = operators.pop();
      PermissionExpression leftExp;
      PermissionExpression rightExp;
      PermissionExpression exp;
      switch (operator) {
        case "not":
          leftExp = permissions.pop();
          exp = new NotExpression(leftExp);
          break;
        case "and":
          leftExp = permissions.pop();
          rightExp = permissions.pop();
          exp = new AndExpression(leftExp, rightExp);
          break;
        case "or":
          leftExp = permissions.pop();
          rightExp = permissions.pop();
          exp = new OrExpression(leftExp, rightExp);
          break;
        default:
          throw new IllegalArgumentException("Unknown operator:" + operator);
      }
      permissions.push(exp);
    }
  }
}
