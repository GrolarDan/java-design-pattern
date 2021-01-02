package org.jdp.behavioral.mediator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Label extends javafx.scene.control.Label implements UIControl {

  private final UIMediator mediator;

  public Label(UIMediator mediator) {
    this.mediator = mediator;
    this.setMinWidth(100);
    this.setText("Label");
    this.mediator.register(this);
  }

  @Override
  public void controlChanged(UIControl control) {
    log.info("Label received change from {}", control.getControlName());
    setText(control.getControlValue());
  }

  @Override
  public String getControlValue() {
    return getText();
  }

  @Override
  public String getControlName() {
    return "Label";
  }

}
