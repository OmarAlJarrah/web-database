package com.omar.demo.log;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Component
public class Log {
  private final Logger transactionLogger;
  private FileHandler transactionsFileHandler;
  private final Logger errorLogger;
  private FileHandler errorFileHandler;

  public Log() {
    try {
      transactionsFileHandler = new FileHandler("transactions.log", true);
      errorFileHandler = new FileHandler("errors.log", true);
    } catch (IOException e) {
      e.printStackTrace();
    }
    transactionLogger = Logger.getLogger(Log.class.getName());
    transactionLogger.addHandler(transactionsFileHandler);

    errorLogger = Logger.getLogger(Log.class.getName());
    errorLogger.addHandler(errorFileHandler);
  }

  public void logTransaction(String transaction) {
    transactionLogger.info(transaction);
  }
}
