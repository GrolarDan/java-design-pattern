package org.jdp.behavioral.interpreter;

//Non terminal expression
public class OrExpression implements PermissionExpression {

  private final PermissionExpression leftExpression;
  private final PermissionExpression rightExpression;

  public OrExpression(PermissionExpression left, PermissionExpression right) {
    this.leftExpression = left;
    this.rightExpression = right;
  }

  @Override
  public boolean interpret(User user) {
    return leftExpression.interpret(user) || rightExpression.interpret(user);
  }

  @Override
  public String toString() {
    return leftExpression + " OR " + rightExpression;
  }
}
