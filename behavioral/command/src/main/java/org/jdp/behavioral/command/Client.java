package org.jdp.behavioral.command;

public class Client {

  public static void main(String[] args) throws InterruptedException {
    EWSService service = new EWSService();
    
    var c1 = new AddMemberCommand("a@a.com", "spam", service);
    MailTasksRunner.getInstance().addCommand(c1);
    
    var c2 = new AddMemberCommand("b@b.com", "spam", service);
    MailTasksRunner.getInstance().addCommand(c2);
    
    MailTasksRunner.getInstance().shutdown();
  }

}
