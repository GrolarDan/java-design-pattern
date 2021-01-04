package org.jdp.behavioral.memento;

public class WorkflowDesigner {

  private Workflow workflow;

  public void createWorkflow(String name) {
    workflow = new Workflow(name);
  }

  public Workflow getWorkflow() {
    return this.workflow;
  }

  public Memento getMemento() {
    if (workflow == null) {
      return new Memento();
    }
    return new Memento(workflow.getName(), workflow.getSteps());
  }

  public void setMemento(Memento memento) {
    if (memento.isEmpty()) {
      this.workflow = null;
    } else {
      this.workflow = new Workflow(memento.getName(), memento.getSteps());
    }
  }

  public void addStep(String step) {
    workflow.addStep(step);
  }

  public void removeStep(String step) {
    workflow.removeStep(step);
  }

  public void print() {
    System.out.println(workflow);
  }

  public class Memento {

    private final String name;
    private final String[] steps;

    private Memento() {
      name = null;
      steps = null;
    }

    private Memento(String name, String[] steps) {
      this.name = name;
      this.steps = steps;
    }

    private String getName() {
      return name;
    }

    private String[] getSteps() {
      return steps;
    }

    private boolean isEmpty() {
      return name == null && steps == null;
    }
  }
}
