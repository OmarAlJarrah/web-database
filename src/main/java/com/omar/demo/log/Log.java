package com.omar.demo.log;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Component
public class Log {
  private final Logger logger;
  private FileHandler fileHandler;

  public Log() {
    try {
      fileHandler = new FileHandler("transactions.log", true);
    } catch (IOException e) {
      e.printStackTrace();
    }
    logger = Logger.getLogger(Log.class.getName());
    logger.addHandler(fileHandler);
  }

  public void logTransaction(String transaction) {
    logger.info(transaction);
  }
}
