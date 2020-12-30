package org.jdp.behavioral.command;

import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
//Throw Away POC code DON'T USE in PROD
//This is invoker actually executing commands. 
//starts a worker thread in charge of executing commands

@Slf4j
@Service
public class MailTasksRunner implements Runnable {

  private final Thread runner;

  private final List<Command> pendingCommands;

  private volatile boolean stop;

  private MailTasksRunner() {
    pendingCommands = new LinkedList<>();
    runner = new Thread(this);
  }

  //Run method takes pending commands and executes them.
  @Override
  public void run() {

    while (true) {
      Command cmd = null;
      synchronized (pendingCommands) {
        if (pendingCommands.isEmpty()) {
          log.debug("Waiting for new command");
          try {
            pendingCommands.wait();
          } catch (InterruptedException e) {
            log.info("Runner interrupted");
            if (stop) {
              log.info("Runner stopping");
              return;
            }
          }
          log.debug("Waiting ended");
        } else {
          cmd = pendingCommands.remove(0);
        }
      }
      if (cmd != null) {
        log.debug("Executing command {}", cmd);
        cmd.execute();
      }
    }

  }

  //Giving it a command will schedule it for later execution
  public void addCommand(Command cmd) {
    synchronized (pendingCommands) {
      log.debug("Added new command {} to cue", cmd);
      pendingCommands.add(cmd);
      pendingCommands.notifyAll();
    }
  }

  public void start() {
    if (!runner.isAlive()) {
      runner.start();
    }
  }

  public void shutdown() {
    stop = true;
    runner.interrupt();
  }
}
