package org.jdp.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

//Mediator
@Slf4j
public class UIMediator {
  List<UIControl> colleagues = new ArrayList<>();
  
  public void register(UIControl control) {
    colleagues.add(control);
  }
  
  public void valueChanged(UIControl control) {
    log.info("Value of control {} changed to {}. Informing other controls.", control.getControlName(), control.getControlValue());
    colleagues.stream()
            .filter(c -> c != control)
            .forEach(c -> c.controlChanged(control));
  }
}
