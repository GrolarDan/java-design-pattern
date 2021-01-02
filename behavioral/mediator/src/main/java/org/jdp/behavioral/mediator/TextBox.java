package org.jdp.behavioral.mediator;

import javafx.scene.control.TextField;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TextBox extends TextField implements UIControl {

  private UIMediator mediator;
  private boolean mediatedUpdate;

  public TextBox(UIMediator mediator) {
    this.mediator = mediator;
    this.setText("Textbox");
    this.mediator.register(this);
    
    this.textProperty().addListener((v, o, n) -> {
      if (!mediatedUpdate) {
        this.mediator.valueChanged(this);
      }
    });
  }

  @Override
  public void controlChanged(UIControl control) {
    log.info("Text box received change of {}", control.getControlName());
    mediatedUpdate = true;
    setText(control.getControlValue());
    mediatedUpdate = false;
  }

  @Override
  public String getControlValue() {
    return getText();
  }

  @Override
  public String getControlName() {
    return "TextBox";
  }

}
