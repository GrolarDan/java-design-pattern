package org.jdp.behavioral.interpreter;

public class Report {

  private final String name;
  //"NOT ADMIN", "FINANCE_USER AND ADMIN"
  private final String permission;

  public Report(String name, String permissions) {
    this.name = name;
    this.permission = permissions;
  }

  public String getName() {
    return name;
  }

  public String getPermission() {
    return permission;
  }

  @Override
  public String toString() {
    return "Report{" + "name=" + name + '}';
  }

}
