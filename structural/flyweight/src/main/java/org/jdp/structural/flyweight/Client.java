package org.jdp.structural.flyweight;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class Client implements CommandLineRunner {

  private final ErrorMessageFactory errorMessageFactory;
  
  public static void main(String[] args) {
    SpringApplication.run(org.jdp.structural.flyweight.Client.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    SystemErrorMessage msg1 = errorMessageFactory.getMessage(ErrorMessageFactory.ErrorType.GenericSystemError);
    log.info(msg1.getText("2006"));
    
    SystemErrorMessage msg2 = errorMessageFactory.getMessage(ErrorMessageFactory.ErrorType.PageNotFoundError);
    log.info(msg2.getText("8005"));
  }
  
}