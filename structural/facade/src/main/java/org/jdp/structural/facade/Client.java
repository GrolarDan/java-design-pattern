package org.jdp.structural.facade;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jdp.structural.facade.email.EmailFacade;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class Client implements CommandLineRunner {

    private final EmailFacade emailFacade;
    
    public static void main(String[] args) {
        SpringApplication.run(org.jdp.structural.facade.Client.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        Order order = new Order("101", 99.99);

        boolean result = emailFacade.sendOrderEmailWithoutFacade(order);

        log.info("Order Email {}", (result ? "sent!" : "NOT sent..."));
    }

}

// DONE
// 1) Switch println to log
// 2) Refactor application to be a Spring Boot application
// 3) Implement Facade

// Added git config --local core.autocrlf false
// to disable CRLF check