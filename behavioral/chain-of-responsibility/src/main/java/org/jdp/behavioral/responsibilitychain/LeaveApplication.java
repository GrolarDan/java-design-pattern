package org.jdp.behavioral.responsibilitychain;

import java.time.LocalDate;
import java.time.Period;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
//Represents a request in our chain of responsibility

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveApplication {

  public enum Type {
    Sick, PTO, LOP
  };

  public enum Status {
    Pending, Approved, Rejecetd
  };

  private final Type type;

  private final LocalDate from;

  private final LocalDate to;

  private String processedBy;

  @Builder.Default
  private Status status = Status.Pending;

  public int getNoOfDays() {
    return Period.between(from, to).getDays();
  }

  public void approve(String approverName) {
    this.status = Status.Approved;
    this.processedBy = approverName;
  }

  public void reject(String approverName) {
    this.status = Status.Rejecetd;
    this.processedBy = approverName;
  }

  @Override
  public String toString() {
    return type + " leave for " + getNoOfDays() + " day(s) " + status
            + " by " + processedBy;
  }

}
