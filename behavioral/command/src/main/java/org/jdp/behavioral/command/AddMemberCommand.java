package org.jdp.behavioral.command;

//A Concrete implementation of Command.
public class AddMemberCommand implements Command {

  private final String emailAddress;
  private final String mailingList;
  private final EWSService receiver;

  public AddMemberCommand(String emailAddress, String mailingList, EWSService receiver) {
    this.emailAddress = emailAddress;
    this.mailingList = mailingList;
    this.receiver = receiver;
  }
          
  @Override
  public void execute() {
    receiver.addMember(emailAddress, mailingList);
  }
		
}
