package org.jdp.behavioral.interpreter;

//Non-terminal expression 
public class AndExpression implements PermissionExpression {

  private final PermissionExpression leftExpression;
  private final PermissionExpression rightExpression;

  public AndExpression(PermissionExpression leftExpression, PermissionExpression rightExpression) {
    this.leftExpression = leftExpression;
    this.rightExpression = rightExpression;
  }

  @Override
  public boolean interpret(User user) {
    return leftExpression.interpret(user) && rightExpression.interpret(user);
  }

  @Override
  public String toString() {
    return leftExpression + " AND " + rightExpression;
  }

}
