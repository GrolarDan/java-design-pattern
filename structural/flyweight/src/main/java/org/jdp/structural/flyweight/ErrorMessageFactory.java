package org.jdp.structural.flyweight;

//Flyweight factory. Returns shared flyweight based on key

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ErrorMessageFactory {

  //This serves as key for getting flyweight instance
  public enum ErrorType {
    GenericSystemError, PageNotFoundError, ServerError
  }

  private final Map<ErrorType, SystemErrorMessage> errorMessages = new HashMap<>();
  
  public ErrorMessageFactory() {
    log.debug("Constructing error message factory");
    errorMessages.put(ErrorType.GenericSystemError, new SystemErrorMessage(
            "A generic error of type $errorCode occured. Please refer to:\t",
            "http://google.com/q="
    ));
    errorMessages.put(ErrorType.PageNotFoundError, new SystemErrorMessage(
            "Page not found. An error of type $errorCode occured. Please refer to:\t",
            "http://google.com/q="
    ));
    errorMessages.put(ErrorType.ServerError, new SystemErrorMessage(
            "Server error of type $errorCode occured. Please refer to:\t",
            "http://google.com/q="
    ));
    
  }

  public SystemErrorMessage getMessage(ErrorType type) {
    log.debug("Calling get message by type {}", type);
    return errorMessages.get(type);
  }
  
  public UserBannedErrorMessage getUserBannedMessage(String caseId) {
    return new UserBannedErrorMessage(caseId);
  }
}
