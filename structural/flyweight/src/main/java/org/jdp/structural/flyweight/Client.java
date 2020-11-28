package org.jdp.structural.flyweight;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Client implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(org.jdp.structural.flyweight.Client.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    SystemErrorMessage msg1 = ErrorMessageFactory.getInstance().getMessage(ErrorMessageFactory.ErrorType.GenericSystemError);
    log.info(msg1.getText("2006"));
  }
  
}